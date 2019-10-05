package com.fdmgroup.controller;

import java.util.List;

import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;
import com.fdmgroup.view.RoleManagementView;

public class RoleManagementController {
	IRoleDao roleDao = new RoleJPADao();
	
	public boolean addRole(String role){
		Role newRole = new Role(role);
		
		if(roleDao.findByRoleType(role) == null && roleDao.create(newRole) != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean deleteRole(int roleId){
		Role foundRole = roleDao.findById(roleId);
		
		if(foundRole != null && roleDao.delete(foundRole)){
			return true;
		}else{
			return false;
		}
	}
	
	public void displayAllRoles(){
		List<Role> roleList = roleDao.findAll();
		for(Role role : roleList){
			System.out.println(role.toString());
		}
	}
	
	public void displayRoleManagementPage(){
		RoleManagementView roleManagementView = new RoleManagementView();
		roleManagementView.displayOptions();
	}
}
