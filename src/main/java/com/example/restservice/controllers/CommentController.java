package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.restservice.services.CommentService;
import com.example.restservice.dtos.CommentNoRecursion;
import com.example.restservice.dtos.Comment;
import com.example.restservice.dtos.CommentForList;

@RestController
public class CommentController {
// This means to get the bean called userRepository
//	// Which is auto-generated by Spring, we will use it to handle the data

	@Autowired
	private CommentService commentService;

	@GetMapping("/comment")
	public Page<CommentNoRecursion> comment(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "commentsPerPage", defaultValue = "0") int commentsPerPage,
			@RequestParam(value = "itemId", defaultValue = "0") Long itemId,
			@RequestParam(value = "depth", defaultValue = "3") int depth) {

		if (depth < 1 || depth > 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (commentsPerPage == 0) {
			commentsPerPage = 5;
		}

		var paginator = PageRequest.of(page, commentsPerPage, Sort.by("id").ascending());

		if (itemId == 0) {
			return commentService.findAllForList(paginator);
		}

		return commentService.findByItemId(itemId, paginator);
	}

	/*
	 * private void loadChildComments(Comment comment, int depth, int maxDepth) { if
	 * (depth >= maxDepth) { return; } ;
	 * comment.setCommentChildren(commentService.findAllByParentId(comment.getId()))
	 * ; comment.getCommentChildren().forEach(cmt -> this.loadChildComments(cmt,
	 * depth + 1, maxDepth)); }
	 */
	@GetMapping("/comment/{commentId}")
	public CommentNoRecursion getSingleItem(@PathVariable(value = "commentId") Long id) throws Exception {
		var result = commentService.findById(id);
		if (result.equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return result;
	}

	@DeleteMapping("/comment/{commentId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "OK")
	public void deleteItem(@PathVariable(value = "commentId") Long id) {
		commentService.deleteById(id);
	}

	@PostMapping(path = "/comment") // Map ONLY POST Requests
	public Comment createItem(@RequestBody Comment comment) {
		if (!comment.isValid()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return commentService.saveComment(comment);
	}

	@PutMapping(path = "/comment/{commentId}") // Map ONLY POST Requests
	public CommentForList updateComment(@PathVariable(value = "commentId") Long id, @RequestBody Comment comment) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		if (!comment.isValid()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			return commentService.updateComment(id, comment);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

}
