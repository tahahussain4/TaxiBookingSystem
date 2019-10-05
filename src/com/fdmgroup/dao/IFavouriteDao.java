package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Favourite;

public interface IFavouriteDao extends IStorage<Favourite> {
	public List<Favourite> findUserFavourites(int userId);
	public boolean doesFavouritedBookingExist(int bookingId);
}
