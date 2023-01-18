package com.example.restservice.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Column {

	private Long id;
	private String name;
	private String colour;
	private int sequence;

	private List<Item> items;
	private Team team;

	@JsonIgnore
	public boolean isValid() {
		return !(name == null || name.isEmpty() || team == null || team.equals(null));
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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItem(List<Item> items) {
		this.items = items;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
