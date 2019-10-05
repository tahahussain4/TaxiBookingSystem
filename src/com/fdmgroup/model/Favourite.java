package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FAVOURITES")
@NamedQueries({
	@NamedQuery (name = "favourite.FindAll", query = "SELECT f FROM Favourite f "),
	@NamedQuery (name = "favourite.FindAllUser", query = "SELECT f FROM Favourite f Join f.booking b Join b.customer u Where u.id = :id AND b.deleted=0 AND f.deleted=0"),
	@NamedQuery (name = "favourite.FindByBookingId", query = "SELECT b FROM Favourite f Join f.booking b  Where b.id = :id AND b.deleted=0 AND f.deleted=0") 
})
public class Favourite implements IStorable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int favouriteId;
	
	@JoinColumn(name = "booking")
	@OneToOne(mappedBy="favourite")
	private Booking booking;
	
	@Column(columnDefinition = "Number(1)" ,name = "deleted")
	private boolean deleted;
	
	
	public Favourite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favourite(Booking booking) {
		super();
		this.booking = booking;
	}
	
	public Favourite(int favouriteId) {
		super();
		this.favouriteId = favouriteId;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}


	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getFavouriteId() {
		return favouriteId;
	}
	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favourite [booking=" + booking + ", deleted=" + deleted + "]";
	}	
}
