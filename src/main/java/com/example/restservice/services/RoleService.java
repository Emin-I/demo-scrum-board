package com.example.restservice.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.repositories.PrivilegeRepository;
import com.example.restservice.repositories.RoleRepository;
import com.example.restservice.dtos.Role;
import com.example.restservice.mappers.RoleMapper;
import com.example.restservice.models.PrivilegeModel;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private RoleMapper roleMapper;

	public Page<Role> findAll(Pageable query) {
		return this.roleRepository.findAll(query).map(p -> roleMapper.mapToDto(p));
	}

	public Page<Role> findAllForList(Pageable query) {
		return this.roleRepository.findAll(query).map(p -> roleMapper.mapToDto(p));
	}

	public Role findById(Long id) throws Exception {
		return roleMapper.mapToDto(roleRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Role findByName(String name) throws Exception {
		return roleMapper.mapToDto(roleRepository.findByName(name));// .orElseThrow(() -> new Exception("Not found")));
	}

	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}

	public Role updateRole(Long id, Role role) throws Exception {
		var current = roleRepository.findById(id).orElseThrow(() -> new Exception("Not found"));

		var privilegeIds = new ArrayList<String>();
		role.getPrivileges().forEach((privilege) -> privilegeIds.add(privilege.getId()));

		var privilegesResult = new ArrayList<PrivilegeModel>();
		privilegeRepository.findAllById(privilegeIds).forEach(privilege -> privilegesResult.add(privilege));

		current.setName(role.getName());
		current.setPrivileges(privilegesResult);

		roleRepository.save(current);
		return roleMapper.mapToDto(current);

	}

	public Role saveRole(Role role) {
		var entity = roleMapper.mapFromDto(role);
		var newEntity = roleRepository.save(entity);
		return roleMapper.mapToDto(newEntity);

	}

}
