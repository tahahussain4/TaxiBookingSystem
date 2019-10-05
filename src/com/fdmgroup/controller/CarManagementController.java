package com.fdmgroup.controller;

import com.fdmgroup.dao.CarJPADao;
import com.fdmgroup.dao.ICarDao;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Size;
import com.fdmgroup.view.CarManagementView;

public class CarManagementController {
	ICarDao carDao = new CarJPADao();
	public boolean addCar(String model, Size size, String gearType, int peopleCapacity){
		Car newCar = new Car(model,size,gearType,peopleCapacity);
		Car createdCar = carDao.create(newCar);
		if(createdCar != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean deleteCar(int id){
		
		if(carDao.delete(new Car(id))){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void displayCarManagementPage(){
		CarManagementView carManagementView = new CarManagementView();
		carManagementView.displayCarManagementOptions();
	}
}
