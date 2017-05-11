package com.webosoft.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.webosoft.common.MongoConstants;

@Component
public class VenueDAOImpl implements VenueDAO {

	@Autowired
	protected MongoOperations mongoTemplate;

	public Object searchVenue(BasicDBObject searchParams) {
		String params = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			params = mapper.writeValueAsString(searchParams);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Object venues = mongoTemplate.scriptOps().call("getFilteredVenues", params);
		return venues;
	}

	public Object getVenueDetail(BasicDBObject filterDto) {
		if (filterDto.get("_id") != null) {
			Criteria criteria = new Criteria();
			criteria.is(filterDto.getString("_id"));
			Query query = new Query(criteria);
			BasicDBObject venue = mongoTemplate.findOne(query, VenueDTO.class, MongoConstants.VENUE_COLLECTION);
			return venue;
		}
		return null;
	}

}
