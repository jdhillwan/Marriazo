package com.webnosoft.venue;

import com.mongodb.BasicDBObject;
import com.webosoft.common.FilterDTO;

public interface VenueService {

	Object getVenue(BasicDBObject searchParams);

}
