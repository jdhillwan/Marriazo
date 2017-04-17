package com.webosoft.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webosoft.common.MongoConstants;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public UserDTO register(UserDTO userDto) {
		return (UserDTO) loginDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

	public SubscribeDTO subscribe(SubscribeDTO subscribeDto) {
		return (SubscribeDTO) loginDAO.save(subscribeDto, MongoConstants.SUBSCRIBE_COLLECTION);
	}

	public UserDTO profile(UserDTO userDto) {
		// TODO Auto-generated method stub
		return (UserDTO) loginDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

}
