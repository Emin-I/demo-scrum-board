package com.example.restservice.models;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class ItemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String body;
	private String title;

	// assign current time
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dueDate;

	@PrePersist
	private void onCreate() {
		dueDate = new Date();
	}

	@ManyToOne
	private ColumnModel columnModel;

	@OneToMany(mappedBy = "itemModel")
	private List<CommentModel> commentModel;

	@ManyToOne
	private UserModel userModel;

	public ItemModel() {
	}

	public ItemModel(Long id, String title, String body, Date dueDate, boolean done) {
		this.id = id;
		this.body = body;
		this.title = title;
		this.dueDate = dueDate;

	}

	public void setColumn(ColumnModel cm) {
		this.columnModel = cm;

	}

	public ColumnModel getColumn() {
		return columnModel;
	}

	public UserModel getUser() {
		return userModel;
	}

	public void setUser(UserModel user) {
		this.userModel = user;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public boolean isValid() {
		return !(title == null || title.isEmpty() || body == null || body.isEmpty() || columnModel.getId() == 0);
	}
}
