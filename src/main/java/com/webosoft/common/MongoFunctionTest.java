package com.webosoft.common;

import com.mongodb.MongoClient;

public class MongoFunctionTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost");
		com.mongodb.DB db = client.getDB("marriazo");
		String a = db
				.doEval("getFilteredVenues('{\"state\":\"Punjab\",\"city\":\"Chandigarh\",\"date_range\":{\"date_from\":1495006200000,\"date_to\":1495024200000},\"price_range\":{\"min\":100,\"max\":100000}}');")
				.toString();
		System.out.println(a);
		client.close();
	}

}

