package com.fdmgroup.controller;

import java.util.List;

import com.fdmgroup.dao.BookingJPADao;
import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.User;
import com.fdmgroup.view.TrackingView;

public class TrackingController {
	IBookingDao bookingDao = new BookingJPADao();
	
	public List<Booking> getAllActiveBookings(User user){
		//gets all bookings after todays date
		return bookingDao.findAfterCurrentDate(user.getId());
	}
	
	public List<Booking> getAllUserBookings(User user){
		//gets all bookings after todays date
		return bookingDao.findAllUserBooking(user.getId());
	}
	
	public Booking getBooking(int bookingId){
		return bookingDao.findById(bookingId);
	}
	
	public void displayPage(){
		TrackingView trackingView = new TrackingView();
		trackingView.displayOption();
	}
}
