package com.example.restservice.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.restservice.models.PrivilegeModel;
import com.example.restservice.models.RoleModel;
import com.example.restservice.models.UserModel;
import com.example.restservice.repositories.PrivilegeRepository;
import com.example.restservice.repositories.RoleRepository;
import com.example.restservice.repositories.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// API

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}

		// == create initial privileges
		final PrivilegeModel readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		final PrivilegeModel writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		final PrivilegeModel passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

		// == create initial roles
		final List<PrivilegeModel> adminPrivileges = new ArrayList<>(
				Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
		final List<PrivilegeModel> userPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));
		final RoleModel adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", userPrivileges);

		// == create initial user
	//	createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<>(Arrays.asList(adminRole)));

		alreadySetup = true;
	}

	@Transactional
	public PrivilegeModel createPrivilegeIfNotFound(final String name) {
		PrivilegeModel privilege = new PrivilegeModel(name, null);
		return privilegeRepository.save(privilege);
	}

	@Transactional
	public RoleModel createRoleIfNotFound(final String name, final Collection<PrivilegeModel> privileges) {
		RoleModel role = roleRepository.findByName(name);
		if (role == null) {
			role = new RoleModel(null, name, null, null);
		}
		role.setPrivileges(privileges);
		role = roleRepository.save(role);
		return role;
	}
/*
	@Transactional
	public UserModel createUserIfNotFound(final String email, final String firstName, final String lastName,
			final String password, final Collection<RoleModel> roles) {
		UserModel user = userRepository.findByMail(email);
		if (user == null) {
			user = new UserModel();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(passwordEncoder.encode(password));
			user.setMail(email);
			user.setEnabled(true);
		}
		user.setRoles(roles);
		user = userRepository.save(user);
		return user;
	}
*/
}
