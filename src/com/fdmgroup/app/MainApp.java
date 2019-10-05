package com.fdmgroup.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fdmgroup.controller.BookingController;
import com.fdmgroup.controller.BookingManagementController;
import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.controller.FavouriteController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.controller.RoleManagementController;
import com.fdmgroup.controller.TrackingController;
import com.fdmgroup.controller.UserManagementController;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Favourite;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.view.BookingView;
import com.fdmgroup.view.HomeView;
import com.fdmgroup.view.TrackingView;



public class MainApp {
	public static void main(String[] args) {
		
		RoleManagementController rmc = new RoleManagementController();
		UserManagementController umc = new UserManagementController();
		UserJPADao userJPADao = new UserJPADao();
		TrackingController tc = new TrackingController();
		TrackingView tv = new TrackingView();
		CarManagementController cmc = new CarManagementController();
		HomeController hc = HomeController.getInstance();
		BookingController bc = new BookingController();
		FavouriteController fc = new FavouriteController();
		BookingManagementController bmc = new BookingManagementController();
		//Roles have to be there to make a customer although they should be made automatically
		Role roleCust = new Role("customer");
		Role roleAdmin = new Role("admin");
		rmc.addRole("customer");
		rmc.addRole("admin");
		
		//add users to the database
		umc.addUser("thussCust", "pass", "taha", "Hussain", roleCust, "14 mistflower", LocalDate.of(1994, 9, 03));
		umc.addUser("thussAdmin", "pass2", "taha", "hussain2", roleAdmin, "taha", LocalDate.of(1994, 9, 03));
		
		
		//create the test users and set logged in user(for adding bookings manually)
		User testCustomer = userJPADao.findByUsername("thussCust");
		User testAdmin = userJPADao.findByUsername("thussAdmin");
		SessionUser.setLoggedInUser(testCustomer);
		
		//create cars
		cmc.addCar("2010",Size.SMALL,"automatic", 4);
		cmc.addCar("2010",Size.SMALL,"automatic", 2);
//		cmc.addCar("2010",Size.MEDIUM,"autmatic", 4);
	
		//create bookings
		bc.addNew(SessionUser.getLoggedInUser(),LocalDate.of(2020, 9, 03), LocalTime.of(12, 13), Size.MEDIUM, "dd", "tt",false);
		bc.addNew(SessionUser.getLoggedInUser(),LocalDate.of(2018, 9, 03), LocalTime.of(14, 13), Size.MEDIUM, "dd", "tt",false);
		//bc.addNew(LocalDate.of(1994, 9, 03), LocalTime.of(12, 13), Size.MEDIUM, "dd", "tt",false);
		//bc.addNew(LocalDate.of(1994, 9, 03), LocalTime.of(12, 13), Size.MEDIUM, "dd", "tt",false);
		//bc.addNew(LocalDate.of(1994, 9, 03), LocalTime.of(12, 13), Size.MEDIUM, "dd", "tt",false);

		//testing change booking
//		bc.changeBooking(8, LocalDate.of(2018, 9, 03), LocalTime.of(12, 13), null, null, null, false);
		
		//Testing favourites
		//fc.addFavourite(7);
		//fc.addFavourite(7);
		User u = new User();
		bmc.addBooking(3,LocalDate.of(2020, 9, 04), LocalTime.of(12, 13), Size.MEDIUM, "dd", "tt",false);
		//umc.deleteUser(3);
		
		//tv.displayAllUserBookings();
		//tv.displayActiveBookings();
		for(;;)
			hc.showHome();

	}
}
