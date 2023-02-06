package com.example.restservice.dtos;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Role {

	private Long id;

	private String name;

	private Collection<UserNoTeams> users;

	private Collection<Privilege> privileges;

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

	public Collection<UserNoTeams> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserNoTeams> users) {
		this.users = users;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	@JsonIgnore
	public boolean isValid() {
		return true;

	}

}
