package com.example.restservice.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "teamModel")
@Entity // This tells Hibernate to make a table out of this class
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TeamModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createdDate;

	@PrePersist
	private void onCreate() {
		createdDate = new Date();
	}

	@ManyToMany(mappedBy = "teams", cascade = CascadeType.MERGE)
	private Set<UserModel> users;
	
	

	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}

	public TeamModel() {
	}

	public TeamModel(Long id, String name, Date createdDate) {
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public boolean isValid() {
		return !(name == null || name.isEmpty());
	}
}
