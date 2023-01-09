package com.example.restservice.dtos;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemForList {
	private Long id;
	private String body;
	private String title;
	private Date dueDate;

	private List<CommentNoItem> comment;

	private UserNoTeams user;

	private ColumnNoItem column;

	@JsonIgnore
	public boolean isValid() {
		return !(title == null || title.isEmpty() || body == null || body.isEmpty()
				|| column == null || column.getId() == 0
				);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<CommentNoItem> getComment() {
		return comment;
	}

	public void setComment(List<CommentNoItem> comment) {
		this.comment = comment;
	}

	public UserNoTeams getUser() {
		return user;
	}

	public void setUser(UserNoTeams user) {
		this.user = user;
	}

	public ColumnNoItem getColumn() {
		return column;
	}

	public void setColumn(ColumnNoItem column) {
		this.column = column;
	}

}
