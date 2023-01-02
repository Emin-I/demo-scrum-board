package com.example.restservice.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.persistence.*;

@Table(name = "userModel")
@Entity // This tells Hibernate to make a table out of this class
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mail;
	private int age;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_user_team", joinColumns = @JoinColumn(name = "user_model_id"), inverseJoinColumns = @JoinColumn(name = "team_model_id"))
	private Collection<TeamModel> teams = new HashSet<TeamModel>();

	@OneToMany(mappedBy = "userModel")
	private List<ItemModel> itemModel;

	public UserModel() {
	}

	public UserModel(String username, String password, Long id, String firstName, String lastName, String mail,
			int age) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.age = age;

	}

	public void setTeams(Collection<TeamModel> teamsResult) {
		this.teams = teamsResult;
	}

	public Collection<TeamModel> getTeams() {
		return teams;
	}

	public List<ItemModel> getItemModel() {
		return itemModel;
	}

	public void setItemModel(List<ItemModel> itemModel) {
		this.itemModel = itemModel;
	}

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

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
