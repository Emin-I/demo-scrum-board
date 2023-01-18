package com.example.restservice.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.CommentNoRecursion;
import com.example.restservice.dtos.Comment;
import com.example.restservice.dtos.CommentForList;
import com.example.restservice.mappers.CommentForListMapper;
import com.example.restservice.mappers.CommentMapper;
import com.example.restservice.mappers.CommentNoRecursionMapper;
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
	@Autowired
	private CommentNoRecursionMapper commentNoRecursionMapper;

	public Page<CommentNoRecursion> findAllForList(Pageable query) {
		return this.commentRepository.findAll(query).map(p -> commentNoRecursionMapper.mapToDto(p));
	}

	public Page<Comment> findAll(Pageable query) {
		return this.commentRepository.findAll(query).map(p -> commentMapper.mapToDto(p));
	}

	public CommentNoRecursion findById(Long id) throws Exception {
		return commentNoRecursionMapper
				.mapToDto(commentRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
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

	public CommentForList updateComment(Long id, Comment comment) throws Exception {
		var current = commentRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
		current.setBody(comment.getBody());
		return commentForListMapper.mapToDto(this.saveComment(current));
	}

	public Page<CommentNoRecursion> findByItemId(Long itemId, PageRequest paginator) {
		return this.commentRepository.findByItemId(itemId, paginator).map(p -> commentNoRecursionMapper.mapToDto(p));
	}

	public List<Comment> findAllByParentId(Long id) {
		return this.commentRepository.findAllByParentId(id).stream().map(p -> commentMapper.mapToDto(p)).toList();

	}
}
