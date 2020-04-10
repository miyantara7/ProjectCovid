package com.lawencon.covid.service;

import com.lawencon.covid.model.User;

public interface UserService {
	
	abstract User findUser(User user) throws Exception;

}
