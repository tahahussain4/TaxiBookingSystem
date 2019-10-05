package com.fdmgroup.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.fdmgroup.controller.BookingController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.Size;
import com.fdmgroup.util.ScannerSupport;

public class BookingView {
	private BookingController bookingController = new BookingController();
	private Scanner scanner = new Scanner(System.in);
	
	public void BookingView(){
		
	}
	
	public void displayBookingOptions(){
		System.out.println("Please Select an option");
		System.out.println("1) add a new booking" + "\n" + "2) Change exsiting" + "\n" + "3) Delete a Booking");
		String option = scanner.nextLine();
		switch(option){
			case "1":
				displayAddNew();
				break;
			case "2":
				displayChangeExisting();
				break;
			case "3":
				displayDeleteExisitng();
				break;
			case "4":
				System.out.println("invalid option");
				displayBookingOptions();
		}
	}
	
	public void displayAddNew(){
		System.out.println("Please Add the following Details");
		
		System.out.println("Please specify what time you want to be picked up at in th format HH:MM");
		LocalTime localTime = ScannerSupport.getTime();
		
		System.out.println("Please Specify what date you want to be picked up at in the format DD/MM/YYYY");
		LocalDate localDate = ScannerSupport.getDate();
		
		
		System.out.println("Please Specify the size of the car you require  1)Big 2)Medium 3)Small ");
		String gearTypeOption  = scanner.nextLine();
		Size size;
		switch (gearTypeOption) {
		case "1":
			size = Size.LARGE;
			break;
		case "2":
			size = Size.MEDIUM;
		case "3":
			size = Size.SMALL;
		default:
			size = null;
			break;
		}
		
		System.out.println("Please specify your pickup address");
		String pickUpLocation = scanner.nextLine();
		
		System.out.println("Please spcify your dropoff location");
		String destination = scanner.nextLine();
		
		System.out.println("Are you interested in carpooling 1)yes 2)no");
		String carpoolingDecisionOption = scanner.nextLine();
		boolean carPoolDecision;
		switch (carpoolingDecisionOption) {
		case "1":
			carPoolDecision = true;
			break;
		case "2":
			carPoolDecision = false;
		default:
			carPoolDecision = false;
			break;
		}
		bookingController.addNew(SessionUser.getLoggedInUser(),localDate,localTime,size,pickUpLocation,destination,carPoolDecision);
		
	}
	
	public void displayChangeExisting(){
		System.out.println("Please specify the booking id ");
		
		int bookingId = ScannerSupport.getInt();
		
		System.out.println("Please enter what you want to change");

		System.out.println(""
				+ "1) Date/Time \n "
				+ "2) Size of Car \n"
				+ "3) Pick up location \n"
				+ "4) Destination \n"
				+ "5) Car Pool Option");
		
		String option = scanner.nextLine();
		
		Size size = null;
		LocalDate localDate= null;
		LocalTime localTime = null;
		String pickUpLocation = null;
		String destination = null;
		Boolean carPoolDecision = null;
		
		switch(option){
		case"1":
			System.out.println("Please specify what date you want to be picked up at");
			localDate = ScannerSupport.getDate();
			
			System.out.println("Please specify what time you want to be picked up at");
			localTime = ScannerSupport.getTime();
			break;
		case"2":
			System.out.println("Please Specify the size of the car you require  1)Big 2)Medium 3)Small ");
			String gearTypeOption  = scanner.nextLine();
			switch (gearTypeOption) {
			case "1":
				size = Size.LARGE;
				break;
			case "2":
				size = Size.MEDIUM;
			case "3":
				size = Size.SMALL;
			default:
				size = null;
				break;
			}
			break;
		case"3":
			System.out.println("Please specify your pickup address");
			pickUpLocation = scanner.nextLine();
			break;
		case"4":	
			System.out.println("Please spcify your dropoff location");
			destination = scanner.nextLine();
			break;
		case"5":
			System.out.println("Are you interested in carpooling 1)yes 2)no");
			String carpoolingDecisionOption = scanner.nextLine();
			switch (carpoolingDecisionOption) {
			case "1":
				carPoolDecision = true;
				break;
			case "2":
				carPoolDecision = false;
			default:
				carPoolDecision = false;
				break;
			}
			break;
		}
		
		bookingController.changeBooking(SessionUser.getLoggedInUser(),bookingId,localDate,localTime,size,pickUpLocation,destination,carPoolDecision);
	}

	
	public void displayDeleteExisitng(){
		System.out.println("Please specify the booking id ");
		int bookingId = scanner.nextInt();
		bookingController.deleteBooking(SessionUser.getLoggedInUser(),bookingId);
	}	
}
