package com.lawencon.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.covid.dao.UserDao;
import com.lawencon.covid.model.User;

@Service
public class UserImplService implements UserService {

	@Autowired
	private UserDao user_dao;
	
	@Override
	public User findUser(User user) throws Exception {
		return user_dao.findUser(user);
	}

}
