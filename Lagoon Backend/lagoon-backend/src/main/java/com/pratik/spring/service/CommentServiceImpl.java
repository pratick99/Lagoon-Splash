package com.pratik.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.spring.dao.CommentDao;
import com.pratik.spring.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private CommentDao dao;
	
	@Override
	public Comment save(Comment comment) {
		
		return dao.save(comment);
	}

	@Override
	public List<Comment> findByPhotoId(Long photoId) {
		
		return dao.findByPhotoId(photoId);
	}

	@Override
	public Comment findOne(Long commentId) {
		
		return dao.findOne(commentId);
	}
	
	
}
