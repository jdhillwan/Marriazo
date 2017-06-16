package com.webosoft.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.webosoft.common.MongoConstants;
import com.webosoft.dao.CateringDAO;
import com.webosoft.domains.CatersDTO;
@Component
public class CateringDAOImpl implements CateringDAO {

	@Autowired
	protected MongoOperations mongoTemplate;

	public Object searchCaters(BasicDBObject searchParams) {
		String params = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			params = mapper.writeValueAsString(searchParams);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Object venues = mongoTemplate.scriptOps().call("getFilteredCaters", params);
		return venues;
	}

	public Object getCatersDetail(BasicDBObject filterDto) {
		if (filterDto.get("_id") != null) {
			Criteria criteria = new Criteria();
			criteria.is(filterDto.getString("_id"));
			Query query = new Query(criteria);
			BasicDBObject venue = mongoTemplate.findOne(query, CatersDTO.class, MongoConstants.CATERS_COLLECTION);
			return venue;
		}
		return null;
	}

}
