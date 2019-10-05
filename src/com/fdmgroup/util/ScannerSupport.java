package com.fdmgroup.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ScannerSupport {
	private static Scanner scanner= new Scanner(System.in);
	
	public static LocalDate getDate(){

		for(;;){
			String date = scanner.nextLine();
				
			try{
				String day = date.substring(0, 2);
				String month = date.substring(3, 5);
				String year = date.substring(6, 10);
				
				LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				return localDate;
			}
			catch(Exception e){
				
			}
			
			System.out.println("Please try again");
		}
	}
	
	public static LocalTime getTime(){
		for(;;){
			String time = scanner.nextLine();
				
			try{
				String hour = time.substring(0, 2);
				String minute = time.substring(3, 5);
				
				LocalTime localTime = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));
				return localTime;
			}
			catch(Exception e){
				
			}
			
			System.out.println("Please try again");
		}
	}
	
	public static int getInt(){
		for(;;){
			try{
				String string = scanner.nextLine();
				int returnInt = Integer.parseInt(string);
				return returnInt;
			}
			catch(Exception e){
				
			}
			System.out.println("Please try again");
		}
		
	}
	
}
