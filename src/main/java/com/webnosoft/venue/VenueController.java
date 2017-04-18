package com.webnosoft.venue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webosoft.common.FilterDTO;
import com.webosoft.common.MongoConstants;
import com.webosoft.common.ServiceResponse;

@RestController
@RequestMapping("/venue/")
public class VenueController {

	@Autowired
	private VenueService venueService;

	@RequestMapping(value = "/fetch-all.rest", method = RequestMethod.GET)
	public Object getVenue(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = MongoConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = MongoConstants.PAGE_REQUESTED, required = false) Integer pageRequested,
			@RequestParam(value = MongoConstants.SORT_FIELD, required = false) String sortField,
			@RequestParam(value = MongoConstants.SORT_ORDER, required = false) Integer sortOrder) {

		ServiceResponse responseObj = new ServiceResponse();
		// set filter DTO first
		FilterDTO filterDto = new FilterDTO();
		filterDto.getSearch().put("_id", null);

		responseObj.setData(venueService.getVenue(filterDto));

		return responseObj;
	}

	@RequestMapping(value = "/{venueID}/fetch-one.rest", method = RequestMethod.GET)
	public Object getVenue(@PathVariable("venueID") String venueID, HttpServletResponse response,
			HttpServletRequest request) {

		ServiceResponse responseObj = new ServiceResponse();
		// set filter DTO first
		FilterDTO filterDto = new FilterDTO();
		filterDto.getSearch().put("_id", venueID);

		responseObj.setData(venueService.getVenue(filterDto));

		return responseObj;
	}

}
