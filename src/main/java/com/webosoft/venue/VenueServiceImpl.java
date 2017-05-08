package com.webosoft.venue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDAO venueDAO;

	@SuppressWarnings("unchecked")
	public Object getVenue(BasicDBObject searchParams) {
		// TODO Auto-generated method stub
		List<VenueDTO> venues = (List<VenueDTO>) venueDAO.searchVenue(searchParams);
		
		return venues;
	}

}
