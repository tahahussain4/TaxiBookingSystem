package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Car;
import com.fdmgroup.model.IStorable;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.RoleType;
import com.fdmgroup.model.User;


public class RoleJPADao implements IRoleDao{
	DbConnection connection;
	 
	@Override
	public Role findById(int id) {
		EntityManager em = connection.getInstance().getEntityManager();
		Role foundRole = em.find(Role.class,id); 
		return foundRole;
	}

	@Override
	public List<Role> findAll() {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Role> query = em.createNamedQuery("role.FindAll",Role.class);
		List<Role> resultList= query.getResultList();
		
		return resultList;
	}

	@Override
	public Role create(Role role) {
 		EntityManager em = connection.getInstance().getEntityManager();
 		em.getTransaction().begin();
 		em.persist(role);
 		em.getTransaction().commit();
		return role;
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Role role) {
		EntityManager em = connection.getInstance().getEntityManager();
 		Role foundRole = findById(role.getRoleId());
 		if(foundRole == null || foundRole.isDeleted()){
 			return false;
 		}
 		em.refresh(foundRole);
	
		if( foundRole.getUsers() != null && foundRole.getUsers().size()>1){
			for(User user : foundRole.getUsers()){
				if(user.isDeleted() == false){
					return false;
				}
			}
		}
		
 		
		em.getTransaction().begin();
		foundRole.setDeleted(true);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Role findByRoleType(String roleType) {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Role> query = em.createNamedQuery("role.FindByRoleType",Role.class);
		query.setParameter("roleType", roleType);
		List<Role> resultList= query.getResultList();
		
		if(resultList.size() == 1){
			return resultList.get(0);
		}
		return null;
	}
	
}
