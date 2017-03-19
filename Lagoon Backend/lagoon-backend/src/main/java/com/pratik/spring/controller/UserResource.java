package com.pratik.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.spring.model.User;
import com.pratik.spring.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping("/user/users")
    public String loginSuccesfull() {
        return "Login Successfull";
    }

	@RequestMapping(value="/user/userName", method=RequestMethod.POST)
	public User findByUserName(@RequestBody String userName) {
		 	System.out.println(userName);
	        System.out.println(service.findByUserName(userName));
	        return service.findByUserName(userName);
	}
	 
	@RequestMapping(value="/user/update",method= RequestMethod.POST) 
	public User updateUser(@RequestBody User user){
		return service.saveUser(user);
	}
	 
}
