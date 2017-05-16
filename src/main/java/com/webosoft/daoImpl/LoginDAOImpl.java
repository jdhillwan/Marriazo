package com.webosoft.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.webosoft.common.MongoConstants;
import com.webosoft.dao.LoginDAO;
import com.webosoft.domains.UserDTO;

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

	public List<UserDTO> fetchUsers(Query query, String collectionName) {
		return mongoTemplate.find(query, UserDTO.class, collectionName);
	}

	public BasicDBObject login(String username, String password) {
		ScriptOperations scriptOps = mongoTemplate.scriptOps();

		BasicDBObject mongoResult = (BasicDBObject) scriptOps.call(MongoConstants.FunctionNames.LOGIN.value(), username,
				password);

		if (mongoResult != null) {
			return mongoResult;
		} else {
			return null;
		}
	}

	public BasicDBObject update(UserDTO userDTO, String collectionName) {
		if (userDTO != null && userDTO.get("_id") != null) {
			Query query = new Query(Criteria.where("_id").is(userDTO.get("_id")));
			Update update = Update.fromDBObject(userDTO);
			mongoTemplate.updateMulti(query, update, collectionName);
			return userDTO;
		}

		return userDTO;
	}

}
