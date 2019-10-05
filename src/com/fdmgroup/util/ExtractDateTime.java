package com.fdmgroup.util;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExtractDateTime {

	public static LocalDate getDate(String date){
		try{
			String day = date.substring(8, 10);
			String month = date.substring(5, 7);
			String year = date.substring(0, 4);
			
			LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			return localDate;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static LocalTime getTime(String time){
		try{
			String hour = time.substring(0, 2);
			String minute = time.substring(3, 5);
			
			LocalTime localTime = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));
			return localTime;
		}
		catch(Exception e){
			return null;
		}
	}
}
