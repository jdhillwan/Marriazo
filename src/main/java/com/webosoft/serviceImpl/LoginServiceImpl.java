package com.webosoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.webosoft.common.MongoConstants;
import com.webosoft.dao.LoginDAO;
import com.webosoft.domains.SubscribeDTO;
import com.webosoft.domains.UserDTO;
import com.webosoft.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public Object register(UserDTO userDto) throws Exception {
		String email = userDto.getString("email");
		Criteria criteria = new Criteria();
		criteria.and("email").is(email);
		Query query = new Query(criteria);
		List<UserDTO> users = loginDAO.fetchUsers(query, MongoConstants.USER_COLLECTION);
		if (users.size() > 0) {
			throw new Exception("User Already Exists");
		}
		return (UserDTO) loginDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

	public SubscribeDTO subscribe(SubscribeDTO subscribeDto) {
		return (SubscribeDTO) loginDAO.save(subscribeDto, MongoConstants.SUBSCRIBE_COLLECTION);
	}

	public UserDTO profile(UserDTO userDto) {
		// TODO Auto-generated method stub
		return (UserDTO) loginDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

	public Object login(String username, String password) {
		return loginDAO.login(username, password);
	}

	public Object update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return loginDAO.update(userDTO, MongoConstants.USER_COLLECTION);
	}

	public Object fetchUserDetails(String email) {
		return loginDAO.fetchUserDetails(email, MongoConstants.USER_COLLECTION);
	}

}
