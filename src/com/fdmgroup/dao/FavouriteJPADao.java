package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Favourite;
import com.fdmgroup.model.User;

public class FavouriteJPADao implements IFavouriteDao{
	DbConnection connection;
	
	@Override
	public Favourite findById(int id) {
		EntityManager em = connection.getInstance().getEntityManager();
		Favourite favourite = em.find(Favourite.class,id); 
		return favourite;
	}

	@Override
	public List<Favourite> findAll() {
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Favourite> query = em.createNamedQuery("favourite.FindAll",Favourite.class);
		List<Favourite> favouriteList = query.getResultList();
		
		return favouriteList;
	}

	@Override
	public Favourite create(Favourite favourite) {
 		EntityManager em = connection.getInstance().getEntityManager();
 		em.getTransaction().begin();
 		em.persist(favourite);
 		em.getTransaction().commit();
		return favourite;
	}

	@Override
	public Favourite update(Favourite t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Favourite faovurite) {
		EntityManager em = connection.getInstance().getEntityManager();
		Favourite foundFavourite = findById(faovurite.getFavouriteId());
		
		if (foundFavourite == null || foundFavourite.isDeleted()){
			return false;
		}
		
		em.getTransaction().begin();
		foundFavourite.setDeleted(true);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<Favourite> findUserFavourites(int userId) {
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Favourite> query = em.createNamedQuery("favourite.FindAllUser",Favourite.class);
		query.setParameter("id", userId);
		List<Favourite> favouriteList = query.getResultList();	
		return favouriteList;
	}
	
	public boolean doesFavouritedBookingExist(int bookingId){
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Booking> query = em.createNamedQuery("favourite.FindByBookingId",Booking.class);
		query.setParameter("id", bookingId);
		List<Booking> resultList= query.getResultList();
		
		if(resultList.size() > 0){
			return true;
		}
		return false;
	}
	
}
