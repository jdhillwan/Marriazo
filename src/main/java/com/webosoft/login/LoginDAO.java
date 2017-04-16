package com.webosoft.login;

import com.mongodb.BasicDBObject;

public interface LoginDAO {

	Object save(BasicDBObject objectDto, String collectionName);

}
