package com.webosoft.venue;

import com.mongodb.BasicDBObject;

public interface VenueService {

	Object getVenue(BasicDBObject searchParams);

	Object getVenueDetail(BasicDBObject filterDto);

}
