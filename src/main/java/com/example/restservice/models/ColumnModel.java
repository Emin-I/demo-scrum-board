package com.example.restservice.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ColumnModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String colour;
	private int sequence;

	@OneToMany(mappedBy = "columnModel")
	private List<ItemModel> itemModel;

	@ManyToOne
	private TeamModel teamModel;

	public ColumnModel() {
	}

	@JsonCreator
	public ColumnModel(Long id, String name, String colour, int sequence, TeamModel teamModel,
			List<ItemModel> itemModel) {
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.sequence = sequence;
		this.teamModel = teamModel;
		this.itemModel = itemModel;
	}

	public List<ItemModel> getItems() {
		return itemModel;
	}

	public void setItems(List<ItemModel> itemModel) {
		this.itemModel = itemModel;
	}

	public void setTeam(TeamModel team) {
		this.teamModel = team;
	}

	public TeamModel getTeam() {
		return teamModel;
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

	@JsonIgnore
	public boolean isValid() {
		return !(name == null || name.isEmpty());
	}

}
