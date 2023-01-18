package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.Team;
import com.example.restservice.mappers.TeamMapper;
import com.example.restservice.models.TeamModel;
import com.example.restservice.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamMapper teamMapper;

	public Page<Team> findAll(Pageable query) {
		return this.teamRepository.findAll(query).map(p -> teamMapper.mapToDto(p));
	}

	public Team findById(Long id) throws Exception {
		return teamMapper.mapToDto(teamRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Team saveTeam(Team team) {
		var entity = teamMapper.mapFromDto(team);
		var newEntity = this.saveTeam(entity);

		return teamMapper.mapToDto(newEntity);
	}

	private TeamModel saveTeam(TeamModel team) {
		teamRepository.save(team);
		return team;
	}

	public void deleteById(Long id) {
		teamRepository.deleteById(id);
	}

	public Team updateTeam(Long id, Team team) throws Exception {
		var current = teamRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
		current.setName(team.getName());
		this.saveTeam(current);
		return teamMapper.mapToDto(current);
	}
/*
	public Team mapToDto(TeamModel teamModel) {
		var team = new Team();
		team.setId(teamModel.getId());
		team.setName(teamModel.getName());
		team.setCreatedDate(teamModel.getCreatedDate());
		return team;
	}

	public TeamModel mapFromDto(Team teamDto) {
		var team = new TeamModel();
		team.setId(teamDto.getId());
		team.setName(teamDto.getName());
		team.setCreatedDate(teamDto.getCreatedDate());
		return team;
	}
*/
}
