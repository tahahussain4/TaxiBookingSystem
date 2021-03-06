package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.User;

public interface IUserDao extends IStorage<User> {
	public User findByUsername(String username);
	public List<User> findByFirstName(String firstName);
}
