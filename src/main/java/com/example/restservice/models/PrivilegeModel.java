package com.example.restservice.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PrivilegeModel {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@ManyToMany(mappedBy = "privileges")
	private Collection<RoleModel> roles;

	public PrivilegeModel() {

	}

	public PrivilegeModel(String id, Collection<RoleModel> roles) {
		super();
		this.id = id;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleModel> roles) {
		this.roles = roles;
	}
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; PrivilegeModel other = (PrivilegeModel) obj; if (getName() == null) {
	 * if (other.getName() != null) return false; } else if
	 * (!getName().equals(other.getName())) return false; return true; }
	 * 
	 * @Override public String toString() { final StringBuilder builder = new
	 * StringBuilder();
	 * builder.append("Privilege [name=").append(name).append("]").append("[id=").
	 * append(id).append("]"); return builder.toString(); }
	 */
}
