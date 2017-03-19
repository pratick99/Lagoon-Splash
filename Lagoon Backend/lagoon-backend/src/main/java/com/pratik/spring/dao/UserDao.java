package com.pratik.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pratik.spring.model.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
	
	 List<User> findAll();
	
	 User findByUserId(Long userId);
	
	 User findByUserName(String userName);
	 
	 User save(User user);
	
}
