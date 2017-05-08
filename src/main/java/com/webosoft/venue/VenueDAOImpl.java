package com.webosoft.venue;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		/*Criteria criteria = new Criteria();
		if (searchParams.get("state") != null) {
			criteria.and("state").is(searchParams.getString("state"));
		}
		if (searchParams.get("city") != null) {
			criteria.and("city").is(searchParams.getString("city"));
		}
		if (searchParams.get("price_range") != null) {
			LinkedHashMap<String, Integer> price_range = (LinkedHashMap<String, Integer>) searchParams.get("price_range");
			int minPrice = price_range.get("min");
			int maxPrice = price_range.get("max");
			criteria.and("price").gte(minPrice).lte(maxPrice);
		}
		Query query = new Query(criteria);
		if (searchParams.get("pageSize") != null) {
			query.limit(searchParams.getInt("pageSize"));
		}
		if (searchParams.get("sortKey") != null) {
			String sort[] = { searchParams.getString("sortKey") };
			query.with(new Sort(Sort.Direction.ASC, sort));
		}*/
		String params = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			params = mapper.writeValueAsString(searchParams);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		/*List<VenueDTO> venues = mongoTemplate.find(query, VenueDTO.class, MongoConstants.VENUE_COLLECTION);*/
		Object venues = mongoTemplate.scriptOps().call("getFilteredVenues", params);
		return venues;
	}

}
