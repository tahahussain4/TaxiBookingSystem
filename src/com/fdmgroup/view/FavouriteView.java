package com.fdmgroup.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.controller.FavouriteController;
import com.fdmgroup.model.Favourite;
import com.fdmgroup.util.ScannerSupport;

public class FavouriteView {
	Scanner scanner = new Scanner(System.in);
	FavouriteController favouriteController = new FavouriteController();

	public void displayOption(){
		System.out.println("Please Select an option");
		System.out.println("1) Favourite a booking" + "\n" + "2) Delete Favourite \n 3) display all favourites");
		String option = scanner.nextLine();
		
		switch(option){
			case "1":
				displayFavourtieABooking();
				break;
			case "2":
				displayDeleteFavourite();
				break;
			case "3":
				displayAllFavourites();
				break;
			default:
				System.out.println("invalid option");
				displayOption();
		}
	}
	
	public void displayFavourtieABooking(){
		System.out.println("enter the booking id you want to favourite");
		int bookingId = ScannerSupport.getInt();
		favouriteController.addFavourite(bookingId);
	}
	
	public void displayAllFavourites(){
		System.out.println("Here are all the Favourites");
		
		List<Favourite> favouriteList = favouriteController.getAllUserFavourites();
		for(Favourite favourite : favouriteList){
			System.out.println(favourite.toString());
		}
	}
	
	public void displayDeleteFavourite(){
		displayAllFavourites();
		System.out.println("enter the booking id that you want to get rid of");
		int bookingId = ScannerSupport.getInt();
		favouriteController.deleteFavourite(bookingId);
	}
	
	public void displayNewBooking(){
		System.out.println("enter the favourited booking id that you want to rebook");
		int bookingId = ScannerSupport.getInt();
		
		System.out.println("Please specify what date you want to be picked up at");
		LocalDate localDate = ScannerSupport.getDate();
		
		System.out.println("Please specify what time you want to be picked up at");
		LocalTime localTime = ScannerSupport.getTime();
		
		favouriteController.bookAFavourite(bookingId, localDate, localTime);
	}
}
