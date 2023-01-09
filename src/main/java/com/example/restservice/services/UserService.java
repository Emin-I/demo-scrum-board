package com.example.restservice.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.restservice.dtos.User;
import com.example.restservice.mappers.*;
import com.example.restservice.models.TeamModel;
import com.example.restservice.repositories.TeamRepository;
import com.example.restservice.repositories.UserRepository;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapperForAuthFilter userMapperForAuthFilter;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapperForAuthFilter.mapToDto(userRepository.findByUsername(username));

		if (user.getId() != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}
		throw new UsernameNotFoundException(username);
	}

	public User save(User user) {
		return userMapper.mapToDto(userRepository.save(userMapper.mapFromDto(user)));
		/*
		var entity = userMapper.mapFromDto(user);
		var newEntity = userRepository.save(entity);
		Long idd=newEntity.getId();
		var dto = userMapper.mapToDto(newEntity);
		dto.setId(idd);
		return dto;
		*/
	}

	public User updateUser(Long id, User user) throws Exception {

		var currentModel = userRepository.findById(id).orElseThrow(() -> new Exception("Not found"));

		var teamIds = new ArrayList<Long>();
		user.getTeams().forEach((team) -> teamIds.add(team.getId()));
		
		var teamsResult = new ArrayList<TeamModel>();
		teamRepository.findAllById(teamIds).forEach(team -> teamsResult.add(team));

		currentModel.setFirstName(user.getFirstName());
		currentModel.setLastName(user.getLastName());
		currentModel.setMail(user.getMail());
		currentModel.setAge(user.getAge());
		currentModel.setTeams(teamsResult);
		return userMapper.mapToDto(userRepository.save(currentModel));
		
	}

	public Page<User> findAll(Pageable query) {
		return this.userRepository.findAll(query).map(p -> userMapper.mapToDto(p));
	}

	public User findById(Long id) throws Exception {
		return userMapper.mapToDto(userRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public User getByUsername(String name) {
		return userMapper.mapToDto(userRepository.findByUsername(name));
	}

	public boolean isMemberOfTeam(Long userId, Long teamId) {
		 return teamRepository.findById(teamId).get().getUsers().stream().anyMatch(u -> u.getId() == userId );
		
	}

}
