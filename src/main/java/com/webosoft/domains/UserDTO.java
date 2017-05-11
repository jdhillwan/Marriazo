package com.webosoft.domains;

import java.io.Serializable;
import java.util.Map;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;

public class UserDTO extends BasicDBObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDTO() {
		super();
	}

	public UserDTO(Map<?, ?> base) {
		super(base);
	}

	public UserDTO(BSONObject base) {
		super();
		this.putAll(base);
	}
}
