package com.pratik.spring.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.spring.model.User;
import com.pratik.spring.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	 @RequestMapping(value="login", method = RequestMethod.POST)
	    public String login(@RequestBody Map<String, String> json) throws
	            ServletException {
	        if(json.get("username") == null || json.get("password") ==null) {
	            throw new ServletException("Please fill in username and password");
	        }

	        String userName = json.get("username");
	        String password = json.get("password");

	        User user= service.findByUserName(userName);
	        if (user==null) {
	            throw new ServletException("User name not found.");
	        }

	        String pwd = user.getPassword();

	        if(!password.equals(pwd)) {
	            throw new ServletException("Invalid login. Please check your name and password");
	        }

	        return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
	                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	    }

	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User registerUser(@RequestBody User newUser){
		return service.saveUser(newUser);
	}
}
