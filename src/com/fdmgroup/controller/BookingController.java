package com.fdmgroup.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.dao.ICarDao;
import com.fdmgroup.dao.BookingJPADao;
import com.fdmgroup.dao.CarJPADao;
import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;

import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.view.BookingView;

public class BookingController {
    IBookingDao bookingDao = new BookingJPADao();
    
	public void showBookingPage(){
		BookingView bookingView = new BookingView();
		bookingView.displayBookingOptions();
	}
	
	public String deleteBooking(User user,int bookingId){
		Booking foundBooking = bookingDao.findById(bookingId);
		User foundUser=null;
		if(foundBooking != null){
			foundUser = foundBooking.getUser();
		}
		
		if(foundUser != null && (foundUser.getId() == user.getId() || user.getRole().getRoleType() == "admin")
			&& bookingDao.delete(new Booking(bookingId))) {
			return "Booking deleted successfully";
		}
		else{
			return "Booking not deleted successfully";
		}
	}

	public String addNew(User user,LocalDate localDate, LocalTime localTime, Size size, String pickUpLocation, String destination,
			boolean carPoolDecision) {
		LocalDateTime dateTime = LocalDateTime.of(localDate,localTime);
		Car availableCar = availableCar(dateTime,size);
		Booking createdBooking = null;
		
		if(availableCar != null){
			Booking newBooking = new Booking(user,availableCar,dateTime,pickUpLocation,destination,carPoolDecision);
			createdBooking = bookingDao.create(newBooking);
		} else{
			return "No cars available/booking not succesfully created";
		}
		if(createdBooking != null){
			return "booking successfully created";
		}
		else{
			return "booking not succesfully created";
		}
	}

	public String changeBooking(User user,int bookingId, LocalDate localDate, LocalTime localTime, Size size, String pickUpLocation,
			String destination, Boolean carPoolDecision,Boolean deleted) {
		
		Car availableCar = null;
		//GET PROPER CAR
		Booking foundBooking = bookingDao.findById(bookingId);
		LocalDateTime dateTime = null;
		
		if(foundBooking != null){
			if(localDate != null && localTime != null){
				dateTime = LocalDateTime.of(localDate,localTime);
			}
			else if(localDate == null && localTime != null){
				dateTime = LocalDateTime.of(foundBooking.getDateTime().toLocalDate(),localTime);
			}
			else if(localDate != null && localTime == null){
				dateTime = LocalDateTime.of(localDate,foundBooking.getDateTime().toLocalTime());
			}
			else{
				dateTime = null;
			}
			
			if(dateTime != null && size != null){
				availableCar = availableCar(dateTime, size);
			}
			else if(dateTime != null && size == null){
				availableCar = availableCar(dateTime, foundBooking.getCar().getSize());
			} 
			else if(dateTime == null && size!=null){
				availableCar = availableCar(foundBooking.getDateTime(), size);
			}
		}
		
		if(foundBooking != null  && (foundBooking.getUser().getId() == user.getId() || user.getRole().getRoleType().equals("admin"))){
			Booking booking = new Booking(bookingId,user,availableCar,dateTime,pickUpLocation,destination,carPoolDecision,deleted);
			bookingDao.update(booking);
			return "booking update success";
		}
		else{
			return "booking update failed, Please retry";
		}
	}
	
	public Car availableCar(LocalDateTime dateTime , Size size){
		Car foundCar = bookingDao.findCorrectSizeAvailableCarWithin(dateTime, size); 
		if(foundCar != null){
			return foundCar;
		} else {
			System.out.println("Correct Size not available for this time slot,Checking for time slot only");
			return bookingDao.findAvailableCarWithin(dateTime);
		}
	}
}
