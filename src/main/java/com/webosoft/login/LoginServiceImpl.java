package com.webosoft.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.webosoft.common.MongoConstants;

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

}
