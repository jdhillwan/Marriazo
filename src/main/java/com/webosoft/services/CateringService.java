package com.webosoft.services;

import com.mongodb.BasicDBObject;

public interface CateringService {

	Object getCaters(BasicDBObject searchParams);

	Object getCatersDetail(BasicDBObject filterDTO);

}
