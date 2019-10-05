package com.fdmgroup.model;

import java.lang.annotation.Repeatable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fdmgroup.util.BooleanToStringConverter;

@Entity
@Table(name = "BOOKINGS")
@NamedQueries({
	@NamedQuery (name = "booking.FindAll", query = "SELECT b FROM Booking b"),
	@NamedQuery (name = "booking.FindActiveBookings", query = "SELECT b FROM Booking b Join b.customer u where dateTime > CURRENT_TIMESTAMP AND u.id = :id AND b.deleted=0"),
	@NamedQuery (name = "booking.FindUserBookings", query = "SELECT b FROM Booking b Join b.customer u Where u.id = :id  AND b.deleted=0 "),
	@NamedQuery (name = "booking.FindWithinXXMin", query = "SELECT c FROM Car c Where c NOT IN (SELECT c from Booking b Join b.car c Where b.dateTime > :minTime AND b.dateTime < :maxTime) AND c.deleted=0 "),
	@NamedQuery (name = "booking.FindWithinXXMin_Size",  query = "SELECT c FROM Car c Where c NOT IN (SELECT c from Booking b Join b.car c Where b.dateTime > :minTime AND b.dateTime < :maxTime) AND c.deleted=0 AND c.carSize = :carSize ")
})
public class Booking implements IStorable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId; 
	
	@JoinColumn(name = "customer")
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	private User customer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "car")
	private Car car;
	
	@Column(name = "dateTime")
	private LocalDateTime dateTime;
	
	@Column(name = "pickUpLocation")
	private String pickUpLocation;
	
	@Column(name = "destination")
	private String destination;
	
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean carPool;
	
	@JoinColumn(name = "favourite")
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	Favourite favourite;
	
	@Column(columnDefinition = "Number(1)" ,name = "deleted")
	private Boolean deleted;
	

	public Booking(int bookingId, User user, Car car, LocalDateTime dateTime, String pickUpLocation, String destination,
			Boolean carPool) {
		super();
		this.bookingId = bookingId;
		this.customer = user;
		this.car = car;
		this.dateTime = dateTime;
		this.pickUpLocation = pickUpLocation;
		this.destination = destination;
		this.carPool = carPool;
	}
	
	

	public Booking(int bookingId, User customer, Car car, LocalDateTime dateTime, String pickUpLocation,
			String destination, Boolean carPool, Boolean deleted) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.car = car;
		this.dateTime = dateTime;
		this.pickUpLocation = pickUpLocation;
		this.destination = destination;
		this.carPool = carPool;
		this.deleted = deleted;
	}



	public Booking(User user, Car car, LocalDateTime dateTime, String pickUpLocation, String destination,
			Boolean carPool) {
		super();
		this.customer = user;
		this.car = car;
		this.dateTime = dateTime;
		this.pickUpLocation = pickUpLocation;
		this.destination = destination;
		this.carPool = carPool;
	}

	public Booking(int bookingId) {
		super();
		this.bookingId = bookingId;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}


	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return customer;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.customer = user;
	}


	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}


	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}


	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}


	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	/**
	 * @return the pickUpLocation
	 */
	public String getPickUpLocation() {
		return pickUpLocation;
	}


	/**
	 * @param pickUpLocation the pickUpLocation to set
	 */
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}


	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}


	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}


	/**
	 * @return the carPool
	 */
	public Boolean isCarPool() {
		return carPool;
	}


	/**
	 * @param carPool the carPool to set
	 */
	public void setCarPool(Boolean carPool) {
		this.carPool = carPool;
	}





	/**
	 * @return the customer
	 */
	public User getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(User customer) {
		this.customer = customer;
	}


	/**
	 * @return the favourite
	 */
	public Favourite getFavourite() {
		return favourite;
	}


	/**
	 * @param favourite the favourite to set
	 */
	public void setFavourite(Favourite favourite) {
		this.favourite = favourite;
	}


	/**
	 * @return the carPool
	 */
	public Boolean getCarPool() {
		return carPool;
	}


	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}




	public Booking() {
		super();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customer=" + customer + ", car=" + car + ", dateTime=" + dateTime
				+ ", pickUpLocation=" + pickUpLocation + ", destination=" + destination + ", carPool=" + carPool
				+ ", favourite=" + favourite + ", deleted=" + deleted + "]";
	}
	
}
