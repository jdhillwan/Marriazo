package com.webosoft.common;

public class MongoConstants {

	public static final String USER_COLLECTION = "user";
	public static final String SUBSCRIBE_COLLECTION = "subscribe";
	public static final String VENUE_COLLECTION = "venue";

	public static final String PAGE_REQUESTED = "p";
	public static final String PAGE_SIZE = "ps";
	public static final String SORT_FIELD = "sf";
	public static final String SORT_ORDER = "so";
	public static final String LAZY_LOAD = "lazy";
	public static final int PAGE_SIZE_DEFAULT = 100;

	public enum FunctionNames {
		LOGIN("getLogin");

		private String constant;

		private FunctionNames(String constant) {
			this.constant = constant;
		}

		public String value() {
			return constant;
		}
	}

}
