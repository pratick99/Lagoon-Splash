package com.pratik.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.spring.dao.PhotoDao;
import com.pratik.spring.model.Photo;
import com.pratik.spring.model.User;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoDao dao;
	
	@Override
	public Photo save(Photo photo) {

		return dao.save(photo);
	}

	@Override
	public List<Photo> findAll() {

		return dao.findAll();
	}

	@Override
	public List<Photo> findByUser(User user) {
		
		return dao.findByUser(user);
	}

	@Override
	public Photo findByPhotoId(Long photoId) {
	
		return dao.findByPhotoId(photoId);
	}

}
