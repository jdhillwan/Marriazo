package com.webosoft.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

	private static String defaultName = "";

	private static final ThreadLocal<String> DB_NAME = new ThreadLocal<String>();
	private static final ThreadLocal<Map<String, Object>> SESSION_TENANT = new ThreadLocal<Map<String, Object>>();
	private static final HashMap<String, Object> DATABASE_INDEX_MAP = new HashMap<String, Object>();

	@SuppressWarnings("deprecation")
	public MultiTenantMongoDbFactory(final Mongo mongo, final String defaultDatabaseName) {
		super(mongo, defaultDatabaseName);
		MultiTenantMongoDbFactory.defaultName = defaultDatabaseName;
	}

	public static void setDatabaseNameForCurrentThread(final String schemaName) {
		if (schemaName != null && !"".equalsIgnoreCase(schemaName)) {
			DB_NAME.set(schemaName);
		} else {
			DB_NAME.set(MultiTenantMongoDbFactory.defaultName);
		}
	}

	public static String getDatabaseNameForCurrentThread() {
		return DB_NAME.get();
	}

	public static void clearDatabaseNameForCurrentThread() {
		DB_NAME.remove();
	}

	@Override
	public DB getDb() {
		final String tlName = DB_NAME.get();
		final String dbToUse = (tlName != null ? tlName : MultiTenantMongoDbFactory.defaultName);
		createIndexIfNecessaryFor(dbToUse);
		return super.getDb(dbToUse);
	}

	private void createIndexIfNecessaryFor(final String database) {
		// sync and init once
		boolean needsToBeCreated = false;
		synchronized (MultiTenantMongoDbFactory.class) {
			final Object syncObj = DATABASE_INDEX_MAP.get(database);
			if (syncObj == null) {
				DATABASE_INDEX_MAP.put(database, new Object());
				needsToBeCreated = true;
			}
		}
		// make sure only one thread enters with needsToBeCreated = true
		synchronized (DATABASE_INDEX_MAP.get(database)) {
			if (needsToBeCreated) {
			}
		}
	}

	public static void setSessionTenant(Map<String, Object> sessionTenant) {
		MultiTenantMongoDbFactory.SESSION_TENANT.set(sessionTenant);
	}

	public static Map<String, Object> getSessionTenant() {
		return MultiTenantMongoDbFactory.SESSION_TENANT.get();
	}

}