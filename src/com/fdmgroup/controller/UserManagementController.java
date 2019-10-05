package com.fdmgroup.controller;

import java.time.LocalDate;

import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;
import com.fdmgroup.view.UserManagementView;

public class UserManagementController {
	IUserDao userDao = new UserJPADao();
	IRoleDao roleDao = new RoleJPADao();
	
	public String addUser(String username,String password, String firstName, String lastName, Role role, String preferredLocation,LocalDate DOB){
		//Getting existing role
		Role foundRole = roleDao.findByRoleType(role.getRoleType());
		if(foundRole == null){
			return "role not available";
		}
		else{
			User newUser = new User(username, password, firstName, lastName,foundRole,preferredLocation,DOB);

			User createdUser = userDao.create(newUser);
			if(createdUser != null){
				return "User created";
			}
			else{
				return "User not created";
			}
		}
	}
	
	public boolean deleteUser(int userId){
		if(userDao.delete(new User(userId))){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean deleteUser(String username){
		if(userDao.delete(new User(username))){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean updateUser(int userId,String username,String password, String firstName, String lastName, String preferredLocation,LocalDate DOB){
		User updatedUser = userDao.update(new User(userId,username,password,firstName,lastName,preferredLocation,DOB));
		if(updatedUser != null){
			return true;
		}else{
			return false;
		}
	}
	
	public void displayOptions(){
		UserManagementView userManagementView = new UserManagementView();
		userManagementView.displayOptions();
	}
	
	public boolean doesUserExist(int id){
		if(userDao.findById(id) == null){
			return false;
		} else{
			return true;
		}
	}
}
