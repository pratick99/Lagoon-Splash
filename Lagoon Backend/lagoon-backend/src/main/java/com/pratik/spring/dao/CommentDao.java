package com.pratik.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pratik.spring.model.Comment;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long>{
	
	Comment save(Comment comment);
	
	Comment findOne(Long commentId);
	
	List<Comment> findByPhotoId (Long photoId);
}
