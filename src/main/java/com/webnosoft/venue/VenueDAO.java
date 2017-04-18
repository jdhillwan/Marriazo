package com.webnosoft.venue;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.webosoft.common.FilterDTO;

public interface VenueDAO {

	List<BasicDBObject> searchVenue(FilterDTO filterDto);

}
