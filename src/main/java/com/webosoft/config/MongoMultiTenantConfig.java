package com.webosoft.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

/**
 * <h1>MongoMultiTenantConfig</h1>. This class is used to initialize the
 * configuration parameters
 * 
 * @author JatinBansal
 * @version 1.0
 * @since 2017-03-25
 * @see WebMongoDBConfig
 */
@Configuration
public class MongoMultiTenantConfig extends WebMongoDBConfig {
	@PostConstruct
	public void init() {
		initParams.put("DB_NAME_KEY", "marriazo.mongo.dbname");
		initParams.put("DB_HOST_KEY", "marriazo.mongo.dbhost");
		initParams.put("DB_PORT_KEY", "marriazo.mongo.dbport");
		initParams.put("DB_CONCNT_KEY", "marriazo.mongo.concnt");
		initParams.put("DB_USER_KEY", "marriazo.mongo.dbuser");
		initParams.put("DB_PASS_KEY", "marriazo.mongo.dbpassword");

		super.init(initParams);
	}
}