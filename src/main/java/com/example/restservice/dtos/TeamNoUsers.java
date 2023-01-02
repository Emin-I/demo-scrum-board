package com.example.restservice.dtos;

import java.util.Date;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TeamNoUsers {
	private Long id;
	private String name;
	private Date createdDate;

	@JsonIgnore
	private HashSet<User> users;

	@JsonIgnore
	public boolean isValid() {
		return !(name == null || name.isEmpty());
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

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

}
