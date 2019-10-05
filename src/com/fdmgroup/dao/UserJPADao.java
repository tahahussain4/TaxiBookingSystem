package com.fdmgroup.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.User;

public class UserJPADao implements IUserDao{
	DbConnection connection;
	
	@Override
	public User findById(int id) {
		EntityManager em = connection.getInstance().getEntityManager();
		User foundUser = em.find(User.class,id); 
		return foundUser;
	}

	public List<User> findAll() {
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<User> query = em.createNamedQuery("user.FindAll",User.class);
		List<User> userList = query.getResultList();
		
		return userList;
	}

	@Override
	public User create(User user) {
 		EntityManager em = connection.getInstance().getEntityManager();
 		em.getTransaction().begin();
 		em.persist(user);
 		em.getTransaction().commit();
		return user;
	}

	@Override
	public User update(User user) {
		EntityManager em = connection.getInstance().getEntityManager();
		User foundUser = findById(user.getId());
		
		if (foundUser == null){
			return null;
		}
		
		em.getTransaction().begin();
		
		if(user.getFirstName() != null){
			foundUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null){
			foundUser.setLastName(user.getLastName());
		}
		if(user.getUsername() != null){
			foundUser.setUsername(user.getUsername());
		}
		if(user.getPassword() != null){
			foundUser.setPassword(user.getPassword());
		}
		if(user.getPreferedPickupLocation() != null){
			foundUser.setPreferedPickupLocation(user.getPreferedPickupLocation());
		}
		if(user.getRole() != null){
			foundUser.setRole(user.getRole());
		}
		
		em.getTransaction().commit();
		return foundUser;
	}

	@Override
	public boolean delete(User user) {
		EntityManager em = connection.getInstance().getEntityManager();
		User foundUser = null;
		if(user.getId() != 0){
			foundUser = findById(user.getId());
		}
		else if (user.getUsername() != null){
			foundUser = findByUsername(user.getUsername());
		}
		
 		if(foundUser == null || foundUser.isDeleted()){
 			return false;
 		}
		
 		em.refresh(foundUser);
 		em.getTransaction().begin();
		foundUser.setDeleted(true);
		if(foundUser.getBookings()!= null){
			for(Booking b : foundUser.getBookings()){
				b.setDeleted(true);
				if(b.getFavourite() != null){
					b.getFavourite().setDeleted(true);
				}
			}
		}
		
		em.getTransaction().commit();
		return true;
	}

	@Override
	public User findByUsername(String username) {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.FindByUserName",User.class);
		query.setParameter("username", username);
		List<User> resultList= query.getResultList();
		
		if(resultList.size() == 1){
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
