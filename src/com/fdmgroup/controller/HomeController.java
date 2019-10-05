package com.fdmgroup.controller;

import java.time.LocalDate;

import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.RoleType;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.User;
import com.fdmgroup.view.HomeView;

public class HomeController {

	private static HomeController homeController = new HomeController();
	private IUserDao userDao = new UserJPADao();
	private HomeView homeView = HomeView.getInstance();
	private IRoleDao roleDao = new RoleJPADao();
	
	private HomeController() {
		super();
	}
	
	public static HomeController getInstance(){
		/*if (homeController == null){
			homeController = new HomeController();
		}*/
		
		return homeController;
	}

	public void showHome() {
		homeView.displayOptions();
	}

	public void doRegister(String username, String password, String firstname, String lastname, String preferredPickupLocation ,LocalDate DOB) {
		Role role = roleDao.findByRoleType("customer");
		if(role == null){
			role = new Role("customer");
		}
		
		User u = new User(username, password, firstname, lastname, role,preferredPickupLocation,DOB);
		User createdUser = null;
		
		if(userDao.findByUsername(username) == null){
			createdUser = userDao.create(u);
		}
		
		if (createdUser != null){
			System.out.println("Registration successfull.");
			SessionUser.setLoggedInUser(createdUser);
			homeView.showCustomerDashboard();
		}
		else {
			System.out.println("Registration was not successfull.");
			System.out.println("--------------------------------");
			homeView.displayOptions();
		}
	}

	public void doLogin(String username, String password) {
		User foundUser = userDao.findByUsername(username);
		if (foundUser != null && foundUser.getPassword().equals(password)){
			SessionUser.setLoggedInUser(foundUser);
			if(foundUser.getRole().getRoleType().equals("admin")){
				for(;;)
					homeView.showAdminDashBoard();
			}
			else{
				homeView.showCustomerDashboard();
			}
		}
		else {
			System.out.println("Username/Passsword is wrong.");
			homeView.displayOptions();
		}
	}
	
	public void doLogout(){
		SessionUser.setLoggedInUser(null);
		System.out.println("---------------------------");
		homeView.displayOptions();
	}

	public void goToBooking() {
		BookingController bookingController = new BookingController();
		bookingController.showBookingPage();
		
	}

	public void goToTracking() {
		TrackingController trackingController = new TrackingController();
		trackingController.displayPage();
	}

	public void goToUserManagement() {
		UserManagementController userManagementController = new UserManagementController();
		userManagementController.displayOptions();
	}
	
	public void goToFavourites(){
		FavouriteController favouriteController= new FavouriteController();
		favouriteController.displayFavouritePage();
	}
	
	public void goToCarManagement() {
		CarManagementController carManagementController = new CarManagementController();
		carManagementController.displayCarManagementPage();
	}
}