package com.webosoft.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public UserDTO register(UserDTO userDto) {
		return loginDAO.save(userDto);
	}

}
