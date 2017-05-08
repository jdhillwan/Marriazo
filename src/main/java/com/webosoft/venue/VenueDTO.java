package com.webosoft.venue;

import java.io.Serializable;
import java.util.Map;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;

public class VenueDTO extends BasicDBObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894233725241671488L;

	public VenueDTO() {
		super();
	}

	public VenueDTO(Map<?, ?> base) {
		super(base);
	}

	public VenueDTO(BSONObject base) {
		super();
		this.putAll(base);
	}
}
