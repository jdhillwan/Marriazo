package com.webosoft.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.webosoft.common.ServiceResponse;
import com.webosoft.services.CateringService;

@RestController
@RequestMapping("/catering")
public class CateringController {

	@Autowired
	CateringService cateringService;

	@RequestMapping(value = "/fetch-all.rest", method = RequestMethod.POST)
	public Object getCaters(HttpServletResponse response, HttpServletRequest request,
			@RequestBody BasicDBObject searchParams) {

		ServiceResponse responseObj = new ServiceResponse();
		responseObj.setData(cateringService.getCaters(searchParams));

		return responseObj;
	}

	@RequestMapping(value = "/{catersID}/fetch-one.rest", method = RequestMethod.POST)
	public Object getCaters(@PathVariable("catersID") String catersID, HttpServletResponse response,
			HttpServletRequest request) {

		ServiceResponse responseObj = new ServiceResponse();
		BasicDBObject filterDto = new BasicDBObject();
		filterDto.put("_id", catersID);
		responseObj.setData(cateringService.getCatersDetail(filterDto));
		return responseObj;
	}

}
