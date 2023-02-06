package com.example.restservice.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class RoleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<UserModel> users;

	@ManyToMany
	@JoinTable(name = "rel_roles_privileges", joinColumns = @JoinColumn(name = "role_model_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_model_id", referencedColumnName = "id"))
	private Collection<PrivilegeModel> privileges;

	public RoleModel() {
		super();

	}

	public RoleModel(Long id, String name, Collection<UserModel> users, Collection<PrivilegeModel> privileges) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.privileges = privileges;
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

	public Collection<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserModel> users) {
		this.users = users;
	}

	public Collection<PrivilegeModel> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<PrivilegeModel> privileges) {
		this.privileges = privileges;
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final RoleModel role = (RoleModel) obj;
		if (!getName().equals(role.getName())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
		return builder.toString();
	}
*/
}