package com.webosoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.webosoft.common.MongoConstants;
import com.webosoft.dao.RegisterDAO;
import com.webosoft.domains.UserDTO;
import com.webosoft.services.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;

	public Object register(UserDTO userDto) throws Exception {
		String email = userDto.getString("email");
		String mobile = userDto.getString("mobile");
		Criteria criteria = new Criteria();
		criteria.orOperator(new Criteria().and("email").is(email), new Criteria().and("mobile").is(mobile));
		Query query = new Query(criteria);
		List<UserDTO> users = registerDAO.fetchUsers(query, MongoConstants.USER_COLLECTION);
		if (users.size() > 0) {
			return null;
		}
		return (UserDTO) registerDAO.save(userDto, MongoConstants.USER_COLLECTION);
	}

}
