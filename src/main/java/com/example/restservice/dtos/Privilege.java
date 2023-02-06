package com.example.restservice.dtos;

import java.util.HashSet;
import com.example.restservice.models.RoleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Privilege {

	private String id;

	private HashSet<RoleModel> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashSet<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<RoleModel> roles) {
		this.roles = roles;
	}
	@JsonIgnore
	public boolean isValid() {
		return true;

	}

}
