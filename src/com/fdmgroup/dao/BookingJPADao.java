package com.fdmgroup.dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;

public class BookingJPADao implements IBookingDao{
	DbConnection connection;
	
	@Override
	public Booking findById(int id) {
		EntityManager em = connection.getInstance().getEntityManager();
		Booking foundBooking = em.find(Booking.class,id); 
		return foundBooking;
	}

	@Override
	public List<Booking> findAll() {
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Booking> query = em.createNamedQuery("booking.FindAll",Booking.class);
		List<Booking> bookingList = query.getResultList();
		
		return bookingList;
	}

	@Override
	public Booking create(Booking booking) {
 		EntityManager em = connection.getInstance().getEntityManager();
 		em.getTransaction().begin();
 		em.persist(booking);
 		em.getTransaction().commit();
		return booking;
	}

	@Override
	public Booking update(Booking booking) {
		EntityManager em = connection.getInstance().getEntityManager();
		Booking foundBooking = findById(booking.getBookingId());
		
		if (foundBooking == null){
			return null;
		}
		
		em.getTransaction().begin();
		
		if(booking.getCar() != null){
			foundBooking.setCar(booking.getCar());
		}
		if(booking.getDateTime() != null){
			foundBooking.setDateTime(booking.getDateTime());
		}
		if(booking.getPickUpLocation() != null){
			foundBooking.setPickUpLocation(booking.getPickUpLocation());
		}
		if(booking.getDestination() != null){
			foundBooking.setDestination(booking.getDestination());
		}
		if(booking.getFavourite() != foundBooking.getFavourite()){
			foundBooking.setFavourite(booking.getFavourite());
		}
		if(booking.getDeleted() != null && booking.getDeleted() != foundBooking.getDeleted()){
			foundBooking.setDeleted(booking.getDeleted());
		}
		if(foundBooking.isCarPool() != null){
			foundBooking.setCarPool(booking.isCarPool());
		}
		
		em.getTransaction().commit();
		return foundBooking;
	}

	@Override
	public boolean delete(Booking booking) {
		EntityManager em = connection.getInstance().getEntityManager();
		Booking foundBooking = findById(booking.getBookingId());
		
		if (foundBooking == null || foundBooking.getDeleted()){
			return false;
		}
		
		em.getTransaction().begin();
		foundBooking.setDeleted(true);
		if(foundBooking.getFavourite() != null){
			foundBooking.getFavourite().setDeleted(true);
		}
		em.getTransaction().commit();
		return true;
	}
	
	@Override
	public List<Booking> findAfterCurrentDate(int userId){
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Booking> query = em.createNamedQuery("booking.FindActiveBookings",Booking.class);
		query.setParameter("id", userId);
		List<Booking> bookingList = query.getResultList();
		
		return bookingList;
	}
	
	@Override
	public List<Booking> findAllUserBooking(int userId){
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Booking> query = em.createNamedQuery("booking.FindUserBookings",Booking.class);
		query.setParameter("id", userId);
		List<Booking> bookingList = query.getResultList();
		
		return bookingList;
	}
	
	@Override
	public Car findAvailableCarWithin(LocalDateTime dateTime) {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Car> query = em.createNamedQuery("booking.FindWithinXXMin",Car.class);
	
		query.setParameter("maxTime",dateTime.plusMinutes(20));
		query.setParameter("minTime",dateTime.minusMinutes(20));
		List<Car> resultList= query.getResultList();
		if(resultList.size() > 0){
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public Car findCorrectSizeAvailableCarWithin(LocalDateTime time, Size size) {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Car> query = em.createNamedQuery("booking.FindWithinXXMin_Size",Car.class);
		query.setParameter("maxTime",time.plusMinutes(20));
		query.setParameter("minTime", time.minusMinutes(20));
		query.setParameter("carSize", size);
		List<Car> resultList= query.getResultList();
		if(resultList.size() > 0){
			return resultList.get(0);
		}
		return null;
	}
}
