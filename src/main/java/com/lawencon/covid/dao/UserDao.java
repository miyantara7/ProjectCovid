package com.lawencon.covid.dao;

import com.lawencon.covid.model.User;

public interface UserDao {

	abstract User findUser(User user) throws Exception; 
	
}
