package com.example.restservice.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ColumnForList {

	private Long id;
	private String name;
	private String colour;
	private int sequence;

	private List<ItemForList> items;

	private TeamNoUsers team;

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

	public List<ItemForList> getItems() {
		return items;
	}

	public void setItems(List<ItemForList> items) {
		this.items = items;
	}

	public TeamNoUsers getTeam() {
		return team;
	}

	public void setTeam(TeamNoUsers team) {
		this.team = team;
	}

}
