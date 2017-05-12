package com.webosoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webosoft.common.MessageConstants;
import com.webosoft.common.ServiceResponse;
import com.webosoft.domains.UserDTO;
import com.webosoft.services.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/register.rest", method = RequestMethod.POST)
	public Object register(@RequestBody UserDTO userDto) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			if (userDto != null) {
				registerService.register(userDto);
				responseObj.setData(userDto);
				responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
				responseObj.setResponse("User Registered Successfully");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(userDto);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
			responseObj.setResponse(e.getMessage());
		}

		return responseObj;

	}

}
