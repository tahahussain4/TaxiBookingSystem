package com.fdmgroup.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Car;
import com.fdmgroup.model.Size;

public interface IBookingDao extends IStorage<Booking> {
	public List<Booking> findAfterCurrentDate(int userId);
	public List<Booking> findAllUserBooking(int userId);
	Car findAvailableCarWithin(LocalDateTime dateTime);
	Car findCorrectSizeAvailableCarWithin(LocalDateTime time, Size size);
}
