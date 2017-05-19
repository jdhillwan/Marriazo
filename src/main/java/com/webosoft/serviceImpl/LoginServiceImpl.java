package com.webosoft.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.webosoft.common.MongoConstants;
import com.webosoft.dao.LoginDAO;
import com.webosoft.domains.SubscribeDTO;
import com.webosoft.domains.UserDTO;
import com.webosoft.notification.EmailDTO;
import com.webosoft.notification.NotificationUtil;
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
		return (UserDTO) loginDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

	public Object login(String username, String password) {
		return loginDAO.login(username, password);
	}

	public Object update(UserDTO userDTO) {
		return loginDAO.update(userDTO, MongoConstants.USER_COLLECTION);
	}

	public Object fetchUserDetails(String email) {
		return loginDAO.fetchUserDetails(email, MongoConstants.USER_COLLECTION);
	}

	public Object forgotPassword(String userName) {
		BasicDBObject user = (BasicDBObject) loginDAO.fetchUserDetails(userName, MongoConstants.USER_COLLECTION);
		if(user != null){
			EmailDTO emailDTO = new EmailDTO();
			List<String> to = new ArrayList<String>();
			to.add(user.getString("email"));
			emailDTO.setTo(to);
			emailDTO.setSubject("Forgot Password Request");
			emailDTO.setBody("Hi " + user.getString("name") + ",\nYour password for Marriazo Account is : \n" + user.getString("password"));
			NotificationUtil.sendEmail(emailDTO);
			return true;
		}
		return false;
	}

}
