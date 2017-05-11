package com.webosoft.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.webosoft.domains.UserDTO;

public interface RegisterDAO {

	Object save(BasicDBObject objectDto, String collectionName);

	public List<UserDTO> fetchUsers(Query query, String collectionName);
}
