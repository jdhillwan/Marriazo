package com.webnosoft.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDAO venueDAO;

	public Object getVenue(BasicDBObject searchParams) {
		// TODO Auto-generated method stub
		return venueDAO.searchVenue(searchParams);
	}

}
