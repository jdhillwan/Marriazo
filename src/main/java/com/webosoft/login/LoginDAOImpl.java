package com.webosoft.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;

@Component
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	protected MongoOperations mongoTemplate;

	public Object save(BasicDBObject objectDto, String collectionName) {
		if (org.apache.commons.lang3.StringUtils.isBlank(objectDto.getString("_id"))) {
			BasicDBObject mongoResult = (BasicDBObject) mongoTemplate.scriptOps().call("getNextSeq", collectionName);
			String _id = mongoResult.getLong("seq") + "";
			objectDto.put("_id", _id);
		}
		mongoTemplate.save(objectDto, collectionName);
		return objectDto;
	}

}
