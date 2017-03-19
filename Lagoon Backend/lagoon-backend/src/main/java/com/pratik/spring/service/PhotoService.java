package com.pratik.spring.service;

import java.util.List;

import com.pratik.spring.model.Photo;
import com.pratik.spring.model.User;

public interface PhotoService {
	
	Photo save(Photo photo);
	
	List<Photo> findAll();
	
	List<Photo> findByUser(User user);
	
	Photo findByPhotoId(Long photoId);
	
}
