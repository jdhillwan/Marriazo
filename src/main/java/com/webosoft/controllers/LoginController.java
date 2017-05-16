package com.webosoft.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webosoft.common.MessageConstants;
import com.webosoft.common.ServiceResponse;
import com.webosoft.domains.SubscribeDTO;
import com.mongodb.BasicDBObject;
import com.webosoft.domains.UserDTO;
import com.webosoft.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

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

	@RequestMapping(value = "/user-profile.rest", method = RequestMethod.POST)
	public Object subscribe(@RequestBody UserDTO userDto) {
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

	@RequestMapping(value = "/user/update.rest", method = RequestMethod.PUT)
	public Object updateUser(@RequestBody UserDTO userDto) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			if (userDto != null) {
				loginService.update(userDto);
				responseObj.setData(userDto);
				responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
				responseObj.setResponse("user updated successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(userDto);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;

	}

	@RequestMapping(value = "/login.rest", method = RequestMethod.POST)
	public Object login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, HttpSession session) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			String sessionAttr = (String) session.getAttribute("userName");
			if (sessionAttr != null && sessionAttr.equalsIgnoreCase(username)) {
				responseObj.setResponse("UserArleadyLoggedIn");
				BasicDBObject sessionResult = new BasicDBObject();
				sessionResult.put("username", username);
				responseObj.setData(sessionResult);
				return responseObj;
			} else {
				if (username != null && password != null) {
					BasicDBObject searchResult = (BasicDBObject) loginService.login(username, password);
					if (searchResult != null) {
						if(searchResult.get("recordList")!=null){
							session.setAttribute("userName", username);
						}
						responseObj.setData(searchResult);
						responseObj.setResponse(searchResult.get("message").toString());
						responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(null);
			responseObj.setResponse(null);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;
	}

	@RequestMapping(value = "/user/{username}/fetch.rest", method = RequestMethod.POST)
	public Object userByUsername(@PathVariable("username") String username, HttpSession session) {
		ServiceResponse responseObj = new ServiceResponse();
		try {

			if (username != null) {
				BasicDBObject searchResult = (BasicDBObject) loginService.login(username, "");
				if (searchResult != null) {
					responseObj.setData(searchResult.get("RecordList"));
					responseObj.setResponse(searchResult.get("message").toString());
					responseObj.setStatus(MessageConstants.RESPONSE_SUCCESS);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(null);
			responseObj.setResponse(null);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;
	}

	@RequestMapping(value = "/logout.rest", method = RequestMethod.POST)
	public Object logOut(HttpSession session) {
		ServiceResponse responseObj = new ServiceResponse();
		try {
			session.invalidate();
			responseObj.setData(null);
			responseObj.setResponse("sessionOut");
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setData(null);
			responseObj.setResponse(null);
			responseObj.setStatus(MessageConstants.RESPONSE_ERROR);
		}

		return responseObj;
	}

	@RequestMapping(value = "/isloggedIn.rest", method = RequestMethod.POST)
	public Object isLoggedIn(HttpSession session) {
		String sessionAttr = (String) session.getAttribute("userName");
		if (sessionAttr != null) {
			return true;
		}
		return false;
	}

}
