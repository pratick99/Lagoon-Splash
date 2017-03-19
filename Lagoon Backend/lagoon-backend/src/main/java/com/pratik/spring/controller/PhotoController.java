package com.pratik.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.spring.model.Photo;
import com.pratik.spring.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoController {
	
	@Autowired
	private PhotoService service;
	
	@RequestMapping("/allPhotos")
	public List<Photo> getAllPhotos(){
		return service.findAll();
	}
	
	
}	
