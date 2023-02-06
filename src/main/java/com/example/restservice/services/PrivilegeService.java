package com.example.restservice.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.repositories.PrivilegeRepository;
import com.example.restservice.repositories.RoleRepository;
import com.example.restservice.dtos.Privilege;
import com.example.restservice.mappers.PrivilegeMapper;
import com.example.restservice.models.RoleModel;

@Service
public class PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeMapper privilegeMapper;

	public Page<Privilege> findAll(Pageable query) {
		return this.privilegeRepository.findAll(query).map(p -> privilegeMapper.mapToDto(p));
	}

	public Page<Privilege> findAllForList(Pageable query) {
		return this.privilegeRepository.findAll(query).map(p -> privilegeMapper.mapToDto(p));
	}

	public Privilege findByName(String name) throws Exception {
		return privilegeMapper.mapToDto(privilegeRepository.findById(name).orElseThrow(() -> new Exception("Not found")));
	}

	public void deleteById(String id) {
		privilegeRepository.deleteById(id);
	}

	public Privilege updatePrivilege(String name, Privilege privilege) throws Exception {
		var current = privilegeRepository.findById(name).orElseThrow(() -> new Exception("Not found"));

		var roleIds = new ArrayList<Long>();
		privilege.getRoles().forEach((role) -> roleIds.add(role.getId()));

		var rolesResult = new ArrayList<RoleModel>();
		roleRepository.findAllById(roleIds).forEach(role -> rolesResult.add(role));

		current.setId(privilege.getId());
		current.setRoles(rolesResult);

		privilegeRepository.save(current);
		return privilegeMapper.mapToDto(current);

	}

	public Privilege savePrivilege(Privilege privilege) {
		var entity = privilegeMapper.mapFromDto(privilege);
		var newEntity = privilegeRepository.save(entity);
		return privilegeMapper.mapToDto(newEntity);

	}

}
