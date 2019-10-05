package com.fdmgroup.dao;

import com.fdmgroup.model.Role;
import com.fdmgroup.model.RoleType;

public interface IRoleDao extends IStorage<Role>{
	public Role findByRoleType(String roleType);
}
