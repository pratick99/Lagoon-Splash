package com.pratik.spring.service;

import java.util.List;

import com.pratik.spring.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findByUserName(String userName);
	
	public User saveUser(User newUser);
	
}
