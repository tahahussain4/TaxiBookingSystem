package com.fdmgroup.view;

import java.time.LocalDate;
import java.util.Scanner;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.util.ScannerSupport;

public class HomeView {

	private static HomeView homeView = new HomeView();
	private Scanner scanner;
	private HomeController homeController;
	
	private HomeView() {
		super();
		scanner = new Scanner(System.in);
		homeController = HomeController.getInstance();
	}
	
	public static HomeView getInstance(){
		if (homeView == null){
			homeView = new HomeView();
		}
		
		return homeView;
	}

	public void displayOptions() {
		
		System.out.println("Welcome to my Solo Project.");
		System.out.println("Please select one of the options below:");
		System.out.println("1) Login\n2) Register \n3) Exit");
		String option = scanner.nextLine();
		
		switch (option) {
		case "1":
				showLogin();
			break;
		case "2":
				showRegister();
			break;
		case "3":
				System.exit(0);
		default:
			System.out.println("Invalid Option......");
			displayOptions();
			break;
		}
	}

	private void showRegister() {
		
		
		System.out.println("Please enter username:");
		String username = scanner.nextLine();
		
		System.out.println("Please enter password:");
		String password = scanner.nextLine();
		
		System.out.println("Please enter firstname:");
		String firstname = scanner.nextLine();
		
		System.out.println("Please enter lastname:");
		String lastname = scanner.nextLine();
		
		System.out.println("Please enter your DOB in the form DD/MM/YYYY");
		LocalDate localDate = ScannerSupport.getDate();
		
		System.out.println("Please enter your preferred pickupLocation");
		String preferredPickupLocation = scanner.nextLine();
		
		homeController.getInstance().doRegister(username, password, firstname, lastname,preferredPickupLocation,localDate);
		
	}

	private void showLogin() {
		System.out.println("Please enter username:");
		String username = scanner.nextLine();
		
		System.out.println("Please enter password:");
		String password = scanner.nextLine();
		
		homeController.getInstance().doLogin(username, password);
	}

	public void showCustomerDashboard() {
		String option= "";
		while(option != "1"){
			System.out.println("----------------------------");
			System.out.println("Welcome " + SessionUser.getLoggedInUser().getFirstName() + " " + SessionUser.getLoggedInUser().getLastName());
			System.out.println("Please select from the options below:");
			System.out.println("1) Logout 2)Bookings 3)Tracking 4)Favourites");
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				homeController.getInstance().doLogout();
				break;
			case "2":
				homeController.getInstance().goToBooking();
				break;
			case "3":
				homeController.getInstance().goToTracking();
				break;
			case "4":
				homeController.getInstance().goToFavourites();
				break;
			default:
				showCustomerDashboard();
				break;
			}
		}
		
	}
	
	public void showAdminDashBoard(){
		String option= "";
		while(option != "1"){
			System.out.println("----------------------------");
			System.out.println("Welcome " + SessionUser.getLoggedInUser().getFirstName() + " " + SessionUser.getLoggedInUser().getLastName());
			System.out.println("Please select from the options below:");
			System.out.println("1) Logout 2)UserManagement 3)CarManagement 4)exit");
			option = scanner.nextLine();
			switch (option) {
			case "1":
				homeController.getInstance().doLogout();
				break;
			case "2":
				homeController.getInstance().goToUserManagement();
				break;
			case "3":
				homeController.getInstance().goToCarManagement();
				break;
			default:
				showAdminDashBoard();
				break;
			}
		}
	}
}