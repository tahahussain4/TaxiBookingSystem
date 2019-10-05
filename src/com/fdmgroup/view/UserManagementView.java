package com.fdmgroup.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.fdmgroup.controller.UserManagementController;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Role;
import com.fdmgroup.util.ScannerSupport;

public class UserManagementView {
	Scanner scanner = new Scanner(System.in);
	UserManagementController userManagementController  = new UserManagementController();
	IUserDao userDao = new UserJPADao();
	public void displayOptions(){
		System.out.println("Please select an option 1) Add User /n 2)Delete user/n 3)Update user ");
		String option = scanner.nextLine();
		
		switch(option){
			case "1":
				displayAddNewUser();
				break;
			case "2":
				displayDeleteUser();
				break;
			case "3":
				displayUpdateUser();
				break;
			default:
				System.out.println("Please choose a correct option");
				displayOptions();
		}
	}
	
	public void displayAddNewUser(){
		System.out.println("Please enter username:");
		String username = scanner.nextLine();
		
		System.out.println("Please enter password:");
		String password = scanner.nextLine();
		
		System.out.println("Please enter firstname:");
		String firstname = scanner.nextLine();
		
		System.out.println("Please enter lastname:");
		String lastname = scanner.nextLine();
		
		System.out.println("Please enter a role:");
		String role = scanner.nextLine();
		
		System.out.println("Please enter your DOB in the form DD/MM/YYYY");
		LocalDate localDate = ScannerSupport.getDate();
		
		System.out.println("Please enter your preferred pickupLocation");
		String preferredPickupLocation = scanner.nextLine();
		
		userManagementController.addUser(username,password, firstname,lastname,new Role(role),preferredPickupLocation,localDate);
	}
	
	public void displayDeleteUser(){
		System.out.println("please enter username");
		String username = scanner.nextLine();
		userManagementController.deleteUser(username);
	}
	
	public void displayUpdateUser(){
		for(;;){
			System.out.println("enter user id");
			int id = ScannerSupport.getInt();
			if(userManagementController.doesUserExist(id)){
				break;
			}
		}
		String username=null;
		String password=null;
		String firstname=null;
		String lastname=null;
		String preferredPickupLocation=null;
		LocalDate localDate=null; 
		
		System.out.println("What do you want to update 1)username 2)password 3)firstname 4)lastname 5) date of birth 6)preferred pickupLocation");
		String option = scanner.nextLine();
		switch(option){
		case "1" :
			System.out.println("Please enter username:");
			username = scanner.nextLine();
			break;
		case "2" :
			System.out.println("Please enter password:");
			password = scanner.nextLine();
			break;
		case "3" :
			System.out.println("Please enter firstname:");
			firstname = scanner.nextLine();
			break;
		case "4" :
			System.out.println("Please enter lastname:");
			lastname = scanner.nextLine();
			break;
		case "5" :
			System.out.println("Please enter your DOB in the form DD/MM/YYYY");
			localDate = ScannerSupport.getDate();
			break;
		case "6" :
			System.out.println("Please enter your preferred pickupLocation");
			preferredPickupLocation = scanner.nextLine();
			break;
		default :
			System.out.println("Going back to main page");
		}
		userManagementController.updateUser(username,password, firstname,lastname,preferredPickupLocation,localDate);
	}
}
