package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.Comment;
import com.example.restservice.models.CommentModel;
import com.example.restservice.repositories.*;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public Page<Comment> findAll(Pageable query) {
		return this.commentRepository.findAll(query).map(p -> mapToDto(p));
	}

	public Comment findById(Long id) throws Exception {
		return mapToDto(commentRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Comment saveComment(Comment comment) {
		var entity = mapFromDto(comment);
		var newEntity = this.saveComment(entity);

		return mapToDto(newEntity);
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
		return mapToDto(current);
	}

	public Comment mapToDto(CommentModel commentModel) {
		var comment = new Comment();
		comment.setId(commentModel.getId());
		comment.setBody(commentModel.getBody());
		comment.setPostedDate(commentModel.getPostedDate());
		return comment;
	}

	public CommentModel mapFromDto(Comment commentDto) {
		var comment = new CommentModel();
		comment.setId(commentDto.getId());
		comment.setBody(commentDto.getBody());
		comment.setPostedDate(commentDto.getPostedDate());
		return comment;
	}
}
