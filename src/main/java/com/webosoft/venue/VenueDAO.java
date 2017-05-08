package com.webosoft.venue;

import com.mongodb.BasicDBObject;

public interface VenueDAO {

	Object searchVenue(BasicDBObject searchParams);

}
