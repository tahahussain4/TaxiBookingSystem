package com.fdmgroup.controller;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fdmgroup.dao.BookingJPADao;
import com.fdmgroup.dao.FavouriteJPADao;
import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.dao.IFavouriteDao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Favourite;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.view.FavouriteView;

public class FavouriteController {
	IFavouriteDao favouriteDao = new FavouriteJPADao();
	IBookingDao bookingDao = new BookingJPADao();
	
	public void displayFavouritePage(){
		FavouriteView favouriteView = new FavouriteView();
		favouriteView.displayOption();
	}
	
	public boolean addFavourite(User user,int bookingId){
		//if fvaourite(booingid does not exist
		System.out.println(user);
		Booking foundBooking = bookingDao.findById(bookingId);
		
		if(foundBooking != null && foundBooking.getUser().equals(user) && !favouriteDao.doesFavouritedBookingExist(bookingId)){
			Favourite favourite = new Favourite(foundBooking);
			foundBooking.setFavourite(favourite);
			bookingDao.update(foundBooking);
			if(favouriteDao.create(favourite) != null){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean deleteFavourite(int bookingId){
		Booking booking = bookingDao.findById(bookingId);

		if(favouriteDao.delete(new Favourite(booking.getFavourite().getFavouriteId()))){
			booking.setFavourite(null);
			bookingDao.update(booking);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void bookAFavourite(User user,int previousBookingId, LocalDate localDate, LocalTime localTime){
		
		Booking foundBooking = bookingDao.findById(previousBookingId);
		if(foundBooking == null || foundBooking.getUser() != user){
			System.out.println("Wrong booking Id");
			return;
		}
		
		BookingController bc = new BookingController();
		bc.addNew(user,localDate, localTime, foundBooking.getCar().getSize(),foundBooking.getPickUpLocation(), foundBooking.getDestination(), foundBooking.isCarPool());
	}
	
	public List<Favourite> getAllUserFavourites(User user){
		return favouriteDao.findUserFavourites(user.getId());
	}
}
