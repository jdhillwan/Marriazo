package com.webosoft.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Component
public class WebMongoDBConfig implements ServletContextAware {

	private ServletContext servletContext;
	public HashMap<String, String> initParams = new HashMap<String, String>();

	public void init(HashMap<String, String> INIT_PARAMS) {
		this.initParams.put("DB_NAME_KEY", INIT_PARAMS.get("DB_NAME_KEY"));
		this.initParams.put("DB_HOST_KEY", INIT_PARAMS.get("DB_HOST_KEY"));
		this.initParams.put("DB_PORT_KEY", INIT_PARAMS.get("DB_PORT_KEY"));
		this.initParams.put("DB_CONCNT_KEY", INIT_PARAMS.get("DB_CONCNT_KEY"));
		this.initParams.put("DB_USER_KEY", INIT_PARAMS.get("DB_USER_KEY"));
		this.initParams.put("DB_PASS_KEY", INIT_PARAMS.get("DB_PASS_KEY"));
	}

	@Resource
	public Environment env;

	@Bean
	public MongoTemplate mongoTemplate(final Mongo mongo) throws Exception {
		return new MongoTemplate(mongoDbFactory(mongo));
	}

	@Bean
	public MultiTenantMongoDbFactory mongoDbFactory(final Mongo mongo) throws Exception {
		String dbName = servletContext.getInitParameter("marriazo.mongo.dbname");

		if (StringUtils.isBlank(dbName)) {
			throw new Exception("DB_NAME_KEY is missing or could not be retrieved from Servlet Context Parameters.");
		}
		return new MultiTenantMongoDbFactory(mongo(), dbName);
	}

	public @Bean MongoClient mongo() throws UnknownHostException {
		String dbName = servletContext.getInitParameter("marriazo.mongo.dbname");
		String concurent = servletContext.getInitParameter("marriazo.mongo.concnt") != null
				? servletContext.getInitParameter("marriazo.mongo.concnt") : "10";
		String dbHost = servletContext.getInitParameter("marriazo.mongo.dbhost") != null
				? servletContext.getInitParameter("marriazo.mongo.dbhost") : "localhost";
		String dbport = servletContext.getInitParameter("marriazo.mongo.port") != null
				? servletContext.getInitParameter("marriazo.mongo.port") : "27017";

		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		MongoClientOptions options = builder.connectionsPerHost(Integer.valueOf(concurent)).build();

		return getMongoClient(dbHost, dbport, dbName, options);
	}

	private MongoClient getMongoClient(String host, String port, String db, MongoClientOptions options) {
		String[] hosts = host.split(",");
		String[] ports = port.split(",");

		MongoClient client = null;
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();

		for (int i = 0; i < hosts.length; i++) {
			seeds.add(new ServerAddress(hosts[i], Integer.valueOf(ports[i])));
		}

		client = new MongoClient(seeds, options);

		return client;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
