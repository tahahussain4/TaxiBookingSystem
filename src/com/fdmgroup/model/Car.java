package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
@NamedQueries({
	@NamedQuery (name = "car.FindBySize", query = "SELECT c FROM Car c WHERE carSize = :carSize AND deleted=0"),
	@NamedQuery (name = "car.FindAll", query = "SELECT c FROM Car c where deleted = 0"),

})
public class Car implements IStorable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carId;
	
	@Column(name = "model")
	private String modeL;
	
	@Column(name = "carSize")
	@Enumerated(EnumType.STRING)
	private Size carSize;
	
	@Column(name = "gearType")
	private String gearType;
	
	@Column(name = "peopleCapcity")
	private int peopleCapacity;

	@Column(columnDefinition = "Number(1)" ,name = "deleted")
	private boolean deleted;
	
	@OneToMany(mappedBy = "car")
	private List<Booking> bookings;
	
	@Column(name = "color")
	private Color color;
	
	
	public Car(int carId) {
		super();
		this.carId = carId;
	}

	public Car() {
		super();
	}

	public Car(int carId, String modeL, Size size, String gearType, int peopleCapacity, boolean deleted) {
		super();
		this.carId = carId;
		this.modeL = modeL;
		this.carSize = size;
		this.gearType = gearType;
		this.peopleCapacity = peopleCapacity;
		this.deleted = deleted;
	}


	public Car(String modeL, Size size, String gearType, int peopleCapacity) {
		super();
		this.modeL = modeL;
		this.carSize = size;
		this.gearType = gearType;
		this.peopleCapacity = peopleCapacity;
	}


	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getModeL() {
		return modeL;
	}


	public void setModeL(String modeL) {
		this.modeL = modeL;
	}

	/**
	 * @return the size
	 */
	public Size getSize() {
		return carSize;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		this.carSize = size;
	}


	public String getGearType() {
		return gearType;
	}


	public void setGearType(String gearType) {
		this.gearType = gearType;
	}


	public int getPeopleCapacity() {
		return peopleCapacity;
	}


	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	@Override
	public String toString() {
		return "Car [carId=" + carId + ", modeL=" + modeL + ", size=" + carSize + ", gearType=" + gearType
				+ ", peopleCapacity=" + peopleCapacity + ", deleted=" + deleted + "]";
	}
	
	
	
}
