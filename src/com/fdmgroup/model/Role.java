package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
@NamedQueries({
	@NamedQuery (name = "role.FindByRoleType", query = "SELECT r FROM Role r WHERE roleType = :roleType"),
	@NamedQuery (name = "role.FindAll", query = "SELECT r FROM Role r ")
})
public class Role implements IStorable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	
	@Column(name = "role")
	private String roleType;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;

	@Column(columnDefinition = "Number(1)" ,name = "deleted")
	private boolean deleted;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleType) {
		super();
		this.roleType = roleType;
	}
	
	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}


	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}


	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + roleType + "]";
	}
	
	
}
