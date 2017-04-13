package com.webosoft.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.webosoft.common.MongoConstants;

@Component
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	protected MongoOperations mongoTemplate;

	// public UserDTO save(UserDTO userDto) {
	// MongoClient mongo = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongo.getDatabase("marriazo");
	//
	// db.runCommand(new Document("$eval", "db.loadServerScripts()"));
	// Document doc1 = db.runCommand(new Document("$eval",
	// "getNextSeq('user')"));
	//
	// String id =
	// ((Double)((Document)doc1.get("retval")).get("seq")).longValue()+"";
	// userDto.put("_id", id);
	//
	// Document doc = new Document(userDto);
	// db.getCollection("user").insertOne(doc);
	//
	// mongo.close();
	// return userDto;
	// }

	public UserDTO save(UserDTO userDto) {

		if (org.apache.commons.lang3.StringUtils.isBlank(userDto.getString("_id"))) {
			BasicDBObject mongoResult = (BasicDBObject) mongoTemplate.scriptOps().call("getNextSeq",
					MongoConstants.REGISTER_COLLECTION);
			long _id = mongoResult.getLong("seq");
			userDto.put("_id", _id);
		}
		mongoTemplate.save(userDto, MongoConstants.REGISTER_COLLECTION);
		return userDto;
	}

}
