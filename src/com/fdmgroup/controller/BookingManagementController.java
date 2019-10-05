package com.fdmgroup.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fdmgroup.dao.BookingJPADao;
import com.fdmgroup.dao.CarJPADao;
import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.dao.ICarDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.view.BookingManagementView;
import com.fdmgroup.view.CarManagementView;

public class BookingManagementController {
	IBookingDao BookingDao = new BookingJPADao();
	IUserDao userDao = new UserJPADao();
	BookingController bc = new BookingController();
	public String addBooking(String username,LocalDate localDate, LocalTime localTime, Size size, String pickUpLocation, String destination,
			boolean carPoolDecision){
		User foundUser = userDao.findByUsername(username);
		if(foundUser==null){
			return "User does not exist";
		}
		
		return bc.addNew(foundUser,localDate,localTime, size,pickUpLocation, destination,carPoolDecision);
	}
	
	public String deleteBooking(User user,int id){
		return bc.deleteBooking(user,id);
	}
	
	public String updateBooking(User user,int bookingId, LocalDate localDate, LocalTime localTime, Size size, String pickUpLocation,
			String destination, Boolean carPoolDecision,Boolean deleted){
		return bc.changeBooking(user,bookingId, localDate, localTime, size, pickUpLocation, destination, carPoolDecision,deleted);
	}
	
	public void displayBookingManagementPage(){
		BookingManagementView BookingManagementView = new BookingManagementView();
		BookingManagementView.displayBookingManagementOptions();
	}
	
}
