package com.webosoft.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webosoft.common.MessageConstants;
import com.webosoft.common.ServiceResponse;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/register.rest", method = RequestMethod.POST)
	public Object register(@RequestBody UserDTO userDto) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			if (userDto != null) {
				loginService.register(userDto);
				responseObj.setData(userDto);
				responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(userDto);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;

	}

	@RequestMapping(value = "/subscribe.rest", method = RequestMethod.POST)
	public Object subscribe(@RequestBody SubscribeDTO subscribeDto) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			if (subscribeDto != null) {
				loginService.subscribe(subscribeDto);
				responseObj.setData(subscribeDto);
				responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(subscribeDto);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;

	}
}
