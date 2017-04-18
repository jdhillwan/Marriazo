package com.webnosoft.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webosoft.common.FilterDTO;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDAO venueDAO;

	public Object getVenue(FilterDTO filterDto) {
		return venueDAO.searchVenue(filterDto);
	}

}
