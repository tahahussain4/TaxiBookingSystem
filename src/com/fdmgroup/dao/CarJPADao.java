package com.fdmgroup.dao;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;

import oracle.net.aso.f;

public class CarJPADao implements ICarDao {
	DbConnection connection;
	@Override
	public Car findById(int id) {
		EntityManager em = connection.getInstance().getEntityManager();
		Car foundCar = em.find(Car.class, id);
		return foundCar;
	}

	@Override
	public List<Car> findAll() {
		EntityManager em = connection.getInstance().getEntityManager();		
		TypedQuery<Car> query = em.createNamedQuery("car.FindAll",Car.class);
		List<Car> carList = query.getResultList();
		
		return carList;
	}

	@Override
	public Car create(Car car) {
 		EntityManager em = connection.getInstance().getEntityManager();
 		em.getTransaction().begin();
 		em.persist(car);
 		em.getTransaction().commit();
		return car;
	}

	@Override
	public Car update(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Car car) {
		EntityManager em = connection.getInstance().getEntityManager();
 		Car foundcar = findById(car.getCarId());
 		if(foundcar == null || foundcar.isDeleted()){
 			return false;
 		}
 		
 		em.refresh(foundcar);
		em.getTransaction().begin();
		foundcar.setDeleted(true);
		for(Booking b: foundcar.getBookings()){
			b.setCar(null);
		}
		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<Car> findBySize(Size carSize) {
		EntityManager em = connection.getInstance().getEntityManager();
		TypedQuery<Car> query = em.createNamedQuery("car.FindBySize",Car.class);
		query.setParameter("carSize", carSize);
		List<Car> resultList= query.getResultList();
		
		return resultList;
	}

}
