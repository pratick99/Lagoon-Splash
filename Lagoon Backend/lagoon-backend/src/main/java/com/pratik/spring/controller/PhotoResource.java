package com.pratik.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pratik.spring.model.Photo;
import com.pratik.spring.model.User;
import com.pratik.spring.service.PhotoService;

@RestController
@RequestMapping("/rest")
public class PhotoResource {
	
	private String imageName;
	
	@Autowired
	private PhotoService service;
	
	@RequestMapping(value="/photo/upload", method= RequestMethod.POST)
	public String upload(HttpServletResponse response, HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest= (MultipartHttpServletRequest) request;
		Iterator<String> it= multipartRequest.getFileNames();
		MultipartFile file= multipartRequest.getFile(it.next());
		String fileName= file.getOriginalFilename();
		imageName=fileName;
		
		String path = new File("src/main/resources/static/images").getAbsolutePath()+"\\"+fileName;
		try{
			file.transferTo(new File(path));
			System.out.println(path);
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return "Upload Success";
	}
	
	@RequestMapping(value="/photo/add", method=RequestMethod.POST)
	public Photo addPhoto(@RequestBody Photo photo){
		photo.setImageName(imageName);
		return service.save(photo);
	}
	
	@RequestMapping(value="/photo/user", method=RequestMethod.POST)
	public List<Photo> photosByUser(@RequestBody User user){
		return service.findByUser(user);
	}
	
	@RequestMapping(value="/photo/photoId", method=RequestMethod.POST)
	public Photo getPhotoById(@RequestBody Long photoId){
		return service.findByPhotoId(photoId);
	}
	
	@RequestMapping(value="/photo/update", method= RequestMethod.POST)
	public void updatePhoto(@RequestBody Photo photo){
		Photo currentPhoto =service.findByPhotoId(photo.getPhotoId());
		currentPhoto.setLikes(photo.getLikes());
		service.save(currentPhoto);
	}
	
}
