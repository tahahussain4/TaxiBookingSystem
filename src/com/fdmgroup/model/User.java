package com.fdmgroup.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@NamedQueries({
	@NamedQuery (name = "user.FindByUserName", query = "SELECT u FROM User u WHERE username = :username"),
	@NamedQuery (name = "user.FindAll", query = "SELECT u FROM User u")
})
public class User implements IStorable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "username")//, unique=true, nullable = false)
	private String username;
	
	@Column(name = "password")//, nullable = false)
	private String password;
	
	@Column(name = "firstName")//, nullable = false)
	private String firstName;
	
	@Column(name = "lastName")//, nullable = false)
	private String lastName; 
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "role")
	private Role role;
	
	@Column(name = "preferredLocation")
	private String preferedPickupLocation;
	
	@Column(name = "DOB", nullable = false)
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "customer")
	private List<Booking> bookings;
	
	@Column(columnDefinition = "Number(1)" ,name = "deleted")
	private boolean deleted;
	
	public User(int id) {
		super();
		this.id = id;
	}

	
	public User(String username) {
		super();
		this.username = username;
	}


	public User(String username, String password, String firstName, String lastName, Role role,
			String preferedPickupLocation, LocalDate dateOfBirth) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.preferedPickupLocation = preferedPickupLocation;
		this.dateOfBirth = dateOfBirth;
	}

	
	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}

	public User(int id, String username, String password, String firstName, String lastName,
			String preferedPickupLocation, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferedPickupLocation = preferedPickupLocation;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}



	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}



	/**
	 * @return the preferedPickupLocation
	 */
	public String getPreferedPickupLocation() {
		return preferedPickupLocation;
	}

	/**
	 * @param preferedPickupLocation the preferedPickupLocation to set
	 */
	public void setPreferedPickupLocation(String preferedPickupLocation) {
		this.preferedPickupLocation = preferedPickupLocation;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User() {
		super();
	}
     
	public User(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}