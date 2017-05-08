package com.webosoft.login;

import java.io.Serializable;
import java.util.Map;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;

public class SubscribeDTO extends BasicDBObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3916570877679197058L;

	/**
	 * 
	 */

	public SubscribeDTO() {
		super();
	}

	public SubscribeDTO(Map<?, ?> base) {
		super(base);
	}

	public SubscribeDTO(BSONObject base) {
		super();
		this.putAll(base);
	}
}
