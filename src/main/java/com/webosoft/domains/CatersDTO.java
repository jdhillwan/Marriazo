package com.webosoft.domains;

import java.io.Serializable;
import java.util.Map;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;

public class CatersDTO extends BasicDBObject implements Serializable {

	private static final long serialVersionUID = 730775488432338473L;

	public CatersDTO() {
		super();
	}

	public CatersDTO(Map<?, ?> base) {
		super(base);
	}

	public CatersDTO(BSONObject base) {
		super();
		this.putAll(base);
	}
}
