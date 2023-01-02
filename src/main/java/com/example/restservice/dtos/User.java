package com.example.restservice.dtos;

import java.util.Collection;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
public class User {
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mail;
	private int age;

	@JsonIgnore
	public boolean isValid() {
		return !(mail == null || mail.isEmpty() || password == null || password.isEmpty() || username == null
				|| username.isEmpty());
	}
	
	private Collection<TeamNoUsers> teams = new HashSet<TeamNoUsers>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTeams( Collection<TeamNoUsers> teamsResult) {
		this.teams = teamsResult;
	}

	public Collection<TeamNoUsers> getTeams() {
		return teams;
	}
}
