package com.example.restservice.dtos;

import java.util.Date;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
public class Team {
	private Long id;
	private String name;
	private Date createdDate;

	private HashSet<UserNoTeams> users;

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

	public HashSet<UserNoTeams> getUsers() {
		return users;
	}

	public void setUsers(HashSet<UserNoTeams> users) {
		this.users = users;
	}

}
