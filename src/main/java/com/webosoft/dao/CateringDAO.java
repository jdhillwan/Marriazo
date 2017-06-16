package com.webosoft.dao;

import com.mongodb.BasicDBObject;

public interface CateringDAO {

	Object searchCaters(BasicDBObject searchParams);

	Object getCatersDetail(BasicDBObject filterDto);
}
