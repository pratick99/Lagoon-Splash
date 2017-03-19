package com.pratik.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.spring.dao.UserDao;
import com.pratik.spring.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@Override
	public List<User> findAll() {
		
		return dao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
	
		return dao.findByUserName(userName);
	}

	@Override
	public User saveUser(User newUser) {
		
		return dao.save(newUser);
	}

}
