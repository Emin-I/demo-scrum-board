package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.restservice.services.CommentService;
import com.example.restservice.dtos.Comment;
import com.example.restservice.dtos.CommentForList;

@RestController
public class CommentController {
//	@Autowired // This means to get the bean called userRepository
//	// Which is auto-generated by Spring, we will use it to handle the data
//	private CommentRepository CommentRepository;
//	@Autowired
//	private ItemRepository ItemRepository;
//	@Autowired
//	private UserRepository UserRepository;
	
	@Autowired
	private CommentService commentService;

	@GetMapping("/comment")
	public Page<CommentForList> comment(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "commentsPerPage", defaultValue = "0") int commentsPerPage,
			@RequestParam(value = "itemId", defaultValue = "0") Long itemId,
			@RequestParam(value = "depth", defaultValue = "3") int depth) {
		
		if(depth < 1 || depth > 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		if (commentsPerPage == 0) {
			commentsPerPage = 5;
		}
		
		var paginator = PageRequest.of(page, commentsPerPage, Sort.by("id").descending());
		
		if (itemId == 0) {
			return commentService.findAllForList(paginator);
		}
		
		return commentService.findByItemId(itemId, paginator);
	}
	/*
	private void loadChildComments(Comment comment, int depth, int maxDepth) {
		if(depth >= maxDepth) { return; };
		comment.setCommentChildren( CommentRepository.findAllByParentId(comment.getId()));
		comment.getCommentChildren().forEach(cmt -> this.loadChildComments(cmt, depth + 1, maxDepth));
	}

	@GetMapping("/comment/{commentId}")
	public CommentModel getSingleItem(@PathVariable(value = "commentId") Long id) {
		var result = CommentRepository.findById(id);
		if (result.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return result.get();
	}

	@DeleteMapping("/comment/{commentId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "OK")
	public void deleteItem(@PathVariable(value = "itemId") Long id) {
		CommentRepository.deleteById(id);
	}
*/
	@PostMapping(path = "/comment") // Map ONLY POST Requests
	public Comment createItem(@RequestBody Comment comment) {
		if (!comment.isValid()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return commentService.saveComment(comment);
	}
/*
	@PutMapping(path = "/comment/{commentId}") // Map ONLY POST Requests
	public CommentModel updateComment(@PathVariable(value = "commentId") Long id, @RequestBody CommentModel comment) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		if (!comment.isValid()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		// for making mandatory
		var currentComment = CommentRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		var item = ItemRepository.findById(comment.getItem().getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		var user = UserRepository.findById(comment.getUser().getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		currentComment.setBody(comment.getBody());
		currentComment.setPostedDate(comment.getPostedDate());
		currentComment.setThumbsUp(comment.isThumbsUp());
		currentComment.setThumbsDown(comment.isThumbsDown());
		currentComment.setItem(item);
		currentComment.setUser(user);

		CommentRepository.save(currentComment);

		return currentComment;
	}
*/
}
