package com.pratik.spring.service;

import java.util.List;

import com.pratik.spring.model.Comment;

public interface CommentService {
	Comment save(Comment comment);
	
	List<Comment> findByPhotoId(Long photoId);
	
	Comment findOne(Long commentId);
	
}
