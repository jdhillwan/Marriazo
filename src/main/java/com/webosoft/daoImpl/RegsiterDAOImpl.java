package com.webosoft.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.webosoft.dao.RegisterDAO;
import com.webosoft.domains.UserDTO;

@Component
public class RegsiterDAOImpl implements RegisterDAO {

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

	public List<UserDTO> fetchUsers(Query query, String collectionName) {
		return mongoTemplate.find(query, UserDTO.class, collectionName);
	}

}
