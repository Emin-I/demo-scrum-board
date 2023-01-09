package com.example.restservice.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.Comment;
import com.example.restservice.dtos.CommentForList;
import com.example.restservice.mappers.CommentForListMapper;
import com.example.restservice.mappers.CommentMapper;
import com.example.restservice.models.CommentModel;
import com.example.restservice.repositories.*;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentForListMapper commentForListMapper;
	@Autowired
	private CommentMapper commentMapper;

	public Page<CommentForList> findAllForList(Pageable query) {
		return this.commentRepository.findAll(query).map(p -> commentForListMapper.mapToDto(p));
	}

	public Page<Comment> findAll(Pageable query) {
		return this.commentRepository.findAll(query).map(p -> commentMapper.mapToDto(p));
	}

	public Comment findById(Long id) throws Exception {
		return commentMapper.mapToDto(commentRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Comment saveComment(Comment comment) {
		var entity = commentMapper.mapFromDto(comment);
		entity.setPostedDate(new Date());
		var newEntity = this.saveComment(entity);

		return commentMapper.mapToDto(newEntity);
	}

	private CommentModel saveComment(CommentModel comment) {
		commentRepository.save(comment);
		return comment;
	}

	public void deleteById(Long id) {
		commentRepository.deleteById(id);
	}

	public Comment updateUser(Long id, Comment comment) throws Exception {
		var current = commentRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
		current.setBody(comment.getBody());
		this.saveComment(current);
		return commentMapper.mapToDto(current);
	}
	/*
	 * public Comment mapToDto(CommentModel commentModel) { var comment = new
	 * Comment(); comment.setId(commentModel.getId());
	 * comment.setBody(commentModel.getBody());
	 * comment.setPostedDate(commentModel.getPostedDate()); return comment; }
	 * 
	 * public CommentModel mapFromDto(Comment commentDto) { var comment = new
	 * CommentModel(); comment.setId(commentDto.getId());
	 * comment.setBody(commentDto.getBody());
	 * comment.setPostedDate(commentDto.getPostedDate()); return comment; }
	 */

	public Page<CommentForList> findByItemId(Long itemId, PageRequest paginator) {
		return this.commentRepository.findByItemId(itemId, paginator).map(p -> commentForListMapper.mapToDto(p));
	}
}
