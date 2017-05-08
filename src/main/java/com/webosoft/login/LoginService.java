package com.webosoft.login;

public interface LoginService {

	Object register(UserDTO userDto) throws Exception;

	SubscribeDTO subscribe(SubscribeDTO subscribeDto);

	UserDTO profile(UserDTO userDto);
}
