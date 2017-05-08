package com.webosoft.venue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.webosoft.common.FilterDTO;
import com.webosoft.common.ServiceResponse;

@RestController
@RequestMapping("/venue")
public class VenueController {

	@Autowired
	private VenueService venueService;

	@RequestMapping(value = "/fetch-all.rest", method = RequestMethod.POST)
	public Object getVenue(HttpServletResponse response, HttpServletRequest request,@RequestBody BasicDBObject searchParams) {

		ServiceResponse responseObj = new ServiceResponse();
		responseObj.setData(venueService.getVenue(searchParams));

		return responseObj;
	}

	@RequestMapping(value = "/{venueID}/fetch-one.rest", method = RequestMethod.POST)
	public Object getVenue(@PathVariable("venueID") String venueID, HttpServletResponse response,
			HttpServletRequest request) {

		ServiceResponse responseObj = new ServiceResponse();
		// set filter DTO first
		FilterDTO filterDto = new FilterDTO();
		filterDto.getSearch().put("_id", venueID);

		/*responseObj.setData(venueService.getVenue(filterDto));*/

		return responseObj;
	}

}
