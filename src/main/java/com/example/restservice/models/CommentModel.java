package com.example.restservice.models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // This tells Hibernate to make a table out of this class
public class CommentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CommentModel commentParent;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commentParent")
	private List<CommentModel> commentChildren;

	private boolean thumbsUp;
	private boolean thumbsDown;

	@ManyToOne
	private UserModel userModel;

	@ManyToOne
	private ItemModel itemModel;

	// assign current time
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date postedDate;

	@PrePersist
	private void sendCommentDate() {
		postedDate = new Date();
	}

	public CommentModel() {
	}

	public CommentModel(Long id, String body, Date postedDate, boolean thumbsUp, boolean thumbsDown) {
		this.id = id;
		this.postedDate = postedDate;
		this.thumbsUp = thumbsUp;
		this.thumbsDown = thumbsDown;

	}

	public void setUser(UserModel user) {
		this.userModel = user;
	}

	public UserModel getUser() {
		return userModel;
	}

	public ItemModel getItem() {
		return itemModel;
	}

	public void setItem(ItemModel item) {
		this.itemModel = item;
	}

	public CommentModel getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(CommentModel commentParent) {
		this.commentParent = commentParent;
	}

	public List<CommentModel> getCommentChildren() {
		return commentChildren;
	}

	public void setCommentChildren(List<CommentModel> iterable) {
		this.commentChildren = iterable;
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

	public boolean isThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(boolean thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	public boolean isThumbsDown() {
		return thumbsDown;
	}

	public void setThumbsDown(boolean thumbsDown) {
		this.thumbsDown = thumbsDown;
	}

	@JsonIgnore
	public boolean isValid() {
		return !(body == null || body.isEmpty() || itemModel.getId() == 0 || userModel.getId() == 0);
	}
}
