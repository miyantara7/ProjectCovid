package com.lawencon.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.covid.model.User;
import com.lawencon.covid.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class UserController extends BaseController<User> {

	@Autowired
	private UserService user_serviec;
	
	@PostMapping("/user")
	public ResponseEntity<?> insertHhiber(@RequestBody String content) {
		User users = new User();
		try {
			User user = readValue(content, User.class);
			users  = user_serviec.findUser(user);
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(users, HttpStatus.BAD_REQUEST);
		}
		
	}
}
