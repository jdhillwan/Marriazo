package com.webosoft.login;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;

public interface LoginDAO {

	Object save(BasicDBObject objectDto, String collectionName);

	public List<UserDTO> fetchUsers(Query query, String collectionName);
}
