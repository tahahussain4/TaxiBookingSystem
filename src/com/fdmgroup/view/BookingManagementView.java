package com.fdmgroup.view;

import java.util.Scanner;

public class BookingManagementView {
	Scanner scanner = new Scanner(System.in);
	
	public void displayBookingManagementOptions(){
		System.out.println("Please Select an option");
		System.out.println("1) Add a newcar" + "\n" + "2) Delete Car \n 3) Back to main menu");
		String option = scanner.nextLine();
		
		switch(option){
			case "1":
				displayAddBooking();
				break;
			case "2":
				displayDeleteBooking();
				break;
			case "3":
				displayUpdateBooking();
				break;
			case "4":
				displayFindNewCar();
			default:
				System.out.println("invalid option");
				displayBookingManagementOptions();
		}
	}
	
	private void displayFindNewCar() {
		// TODO Auto-generated method stub
		
	}

	private void displayUpdateBooking() {
		// TODO Auto-generated method stub
		
	}

	private void displayDeleteBooking() {
		// TODO Auto-generated method stub
		
	}

	public void displayAddBooking(){
		System.out.println("Enter the user id for which you wish to book");
		
	}
}
