package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.model.User;

public class UserCollectionDao implements IUserDao {

	private static UserCollectionDao userCollectionDao = null;
	private List<User> users;
	
	private UserCollectionDao() {
		super();
		users = new ArrayList<>();
		users.add(new User(1, "jdoe", "1234", "John", "Doe"));
		users.add(new User(2, "asmith", "7896", "Alex", "Smith"));
		users.add(new User(3, "dbowie", "159753", "David", "Bowie"));
	}
	
	public static UserCollectionDao getInstance(){
		if (userCollectionDao == null){
			userCollectionDao = new UserCollectionDao();
		}
		
		return userCollectionDao;
	}

	@Override
	public User findById(int id) {
		User u = new User();
		u.setId(id);
		if (users.indexOf(u) != -1)
			return users.get(users.indexOf(u));
		
		return null;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User create(User user) {
		if (users.size() != 0)
			user.setId(users.get(users.size() - 1).getId() + 1);
		else
			user.setId(1);
		
		if (users.add(user))
			return user;
		
		return null;
	}

	@Override
	public User update(User user) {
		if (users.indexOf(user) != -1){
			User changedUser = users.get(users.indexOf(user));
			if (user.getFirstName() != null && !user.getFirstName().equals("")){
				changedUser.setFirstName(user.getFirstName());
			}
			
			if (user.getLastName() != null && !user.getLastName().equals("")){
				changedUser.setLastName(user.getLastName());
			}
			
			if (user.getPassword() != null && !user.getPassword().equals("")){
				changedUser.setPassword(user.getPassword());
			}
			
			return changedUser;
		}
			
		return null;
	}

	@Override
	public boolean delete(User user) {
		if (users.indexOf(user) != -1){
			return users.remove(user);
		}

		return false;
	}

	@Override
	public User findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username))
				return user;
		}
		
		return null;
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		List<User> usersList = new ArrayList<>();
		for (User user : users) {
			if (user.getFirstName().equals(firstName)){
				usersList.add(user);
			}
		}
		
		return usersList;
	}
}