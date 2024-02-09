package com.packt.cardatabase.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerid;
	private String firstname;
	private String lastname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Car> cars;

	// Adding the list of pets with the one-to-many relationship
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Pet> pets = new ArrayList<>();

	// Default constructor
	public Owner() {
	}

	// Constructor with parameters
	public Owner(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	// Getters and setters for cars
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	// Getters and setters for pets
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	// Getters and setters for owner's properties
	public Long getOwnerid() {
		return ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
