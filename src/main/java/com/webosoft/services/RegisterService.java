package com.webosoft.services;

import com.webosoft.domains.UserDTO;

public interface RegisterService {

	Object register(UserDTO userDto) throws Exception;

}
