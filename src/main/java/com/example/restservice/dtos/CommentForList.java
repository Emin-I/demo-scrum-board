package com.example.restservice.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommentForList {

	private Long id;
	private String body;
	private Date postedDate;
	private CommentForList commentParent;
	
	@JsonIgnore
	private List<CommentForList> commentChildren;

	private UserNoTeams user;

	private ItemForList item;

	@JsonIgnore
	public boolean isValid() {
		return !(body == null || body.isEmpty() || item.getId() == 0 || user.getId() == 0);
	}

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

	public CommentForList getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(CommentForList commentParent) {
		this.commentParent = commentParent;
	}

	public List<CommentForList> getCommentChildren() {
		return commentChildren;
	}

	public void setCommentChildren(List<CommentForList> commentChildren) {
		this.commentChildren = commentChildren;
	}

	public UserNoTeams getUser() {
		return user;
	}

	public void setUser(UserNoTeams user) {
		this.user = user;
	}

	public ItemForList getItem() {
		return item;
	}

	public void setItem(ItemForList item) {
		this.item = item;
	}

}
