package com.webnosoft.venue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.webosoft.common.FilterDTO;
import com.webosoft.common.MongoConstants;

@Component
public class VenueDAOImpl implements VenueDAO {

	@Autowired
	protected MongoOperations mongoTemplate;

	public List<BasicDBObject> searchVenue(FilterDTO filterDto) {

		if (filterDto.getSearch().get("_id") != null) {
			Query searchQuery = new Query(
					Criteria.where("_id").is(Integer.parseInt(filterDto.getSearch().get("_id").toString())));
			BasicDBObject response = mongoTemplate.findOne(searchQuery, BasicDBObject.class,
					MongoConstants.VENUE_COLLECTION);
			List<BasicDBObject> responseList = new ArrayList<BasicDBObject>();
			responseList.add(response);
			return responseList;
		} else {
			return mongoTemplate.findAll(BasicDBObject.class, MongoConstants.VENUE_COLLECTION);
		}

	}

}
