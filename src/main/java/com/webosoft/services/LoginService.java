package com.webosoft.services;

import com.webosoft.domains.SubscribeDTO;
import com.webosoft.domains.UserDTO;

public interface LoginService {

	Object register(UserDTO userDto) throws Exception;

	SubscribeDTO subscribe(SubscribeDTO subscribeDto);

	UserDTO profile(UserDTO userDto);

	Object login(String username, String password);

	Object update(UserDTO userDTO);

	Object fetchUserDetails(String email);

	Object forgotPassword(String userName);
}
