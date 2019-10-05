package com.fdmgroup.view;

import java.util.List;
import java.util.Scanner;

import com.fdmgroup.controller.TrackingController;
import com.fdmgroup.model.Booking;
import com.fdmgroup.util.ScannerSupport;

public class TrackingView {
	Scanner scanner = new Scanner(System.in);
	TrackingController trackingController = new TrackingController();
	
	public void displayOption(){
		System.out.println("Please select one of the options below:");
		System.out.println("1) Display all bookings\n 2) displayAllActiveBookings \n 3) Display booking");
		String option = scanner.nextLine();
		
		switch (option) {
		case "1":
				displayAllUserBookings();
				break;
		case "2":
				displayActiveBookings();
				break;
		case "3":
				displayOneBooking();
				break;
		default:
			System.out.println("Invalid Option......");
			displayOption();
			break;
		}
	}
	
	public void displayAllUserBookings(){
		System.out.println("Here is the list of all bookings");
		List<Booking> bookingList = trackingController.getAllUserBookings();
		for(Booking booking : bookingList){
			System.out.println(booking.toString());
		}
	}
	
	public void displayActiveBookings(){
		System.out.println("Here are all the active bookings");
		List<Booking> bookingList = trackingController.getAllActiveBookings();
		for(Booking booking : bookingList){
			System.out.println(booking.toString());
		}
	}
	
	public void displayOneBooking(){
		System.out.println("Please specify the boooking id that you want");
		int bookingId = ScannerSupport.getInt();
		Booking booking = trackingController.getBooking(bookingId);
		System.out.println(booking.toString());
	}
}
