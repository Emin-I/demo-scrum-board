package com.example.restservice.dtos;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommentNoItem {

	private Long id;
	private String body;
	private Date postedDate;
	private Comment commentParent;
	private List<Comment> commentChildren;
	private User user;
	@JsonIgnore
	private Item item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Comment getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(Comment commentParent) {
		this.commentParent = commentParent;
	}

	public List<Comment> getCommentChildren() {
		return commentChildren;
	}

	public void setCommentChildren(List<Comment> commentChildren) {
		this.commentChildren = commentChildren;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
