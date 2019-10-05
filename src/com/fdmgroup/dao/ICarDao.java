package com.fdmgroup.dao;

import java.time.LocalTime;
import java.util.List;

import com.fdmgroup.model.Car;
import com.fdmgroup.model.Size;

public interface ICarDao extends IStorage<Car>{
	public List<Car> findBySize(Size size);
}
