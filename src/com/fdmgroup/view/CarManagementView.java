package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.model.Size;
import com.fdmgroup.util.ScannerSupport;

public class CarManagementView {
	Scanner scanner = new Scanner(System.in);
	CarManagementController carManangementController = new CarManagementController();
	
	public void displayCarManagementOptions(){
		System.out.println("Please Select an option");
		System.out.println("1) Add a newcar" + "\n" + "2) Delete Car \n 3) Back to main menu");
		String option = scanner.nextLine();
		
		switch(option){
			case "1":
				displayAddCar();
				break;
			case "2":
				displayDeleteCar();
				break;
			case "3":
				break;
			default:
				System.out.println("invalid option");
				displayCarManagementOptions();
		}
	}
	
	
	public void displayAddCar(){
		System.out.println("Please enter the following details:");
		
		System.out.println("What model is it");
		String model = scanner.nextLine();
		
		Size size;
		for(;;){
			System.out.println("what is the size 1)large 2)medium 3)small ");
			int option = ScannerSupport.getInt();
			if(option == 1){
				size = Size.LARGE;
				break;
			}
			else if(option == 2){
				size = Size.MEDIUM;
				break;
			}
			else if(option == 3){
				size = Size.SMALL;
				break;
			}
			else{
				System.out.println("Please enter option again");
			}
		}
		
		System.out.println("What gear type is it");
		String gearType = scanner.nextLine();
		
		System.out.println("How many people can be in it ");
		int peopleCapacity = ScannerSupport.getInt();
		
		carManangementController.addCar(model, size, gearType, peopleCapacity);
	}
	
	public void displayDeleteCar(){
		System.out.println("what is the car id");
		int carId = scanner.nextInt();
		
		carManangementController.deleteCar(carId);
	
	}
	
}
