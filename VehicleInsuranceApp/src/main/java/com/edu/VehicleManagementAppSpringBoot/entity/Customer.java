package com.edu.VehicleManagementAppSpringBoot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
@Entity
@Table(name = "customer_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;
	
	
	@Column(name = "contact_number", unique = true)
	private String contactNumber;
	

	@Column
	private String gender;

	@Column(name="DoB")
	private Date dateOfBirth;

	@Column
	private String address;
	
	@Column
	private String nationality;

	@Column(name = "licence_number")
	private String licenceNumber;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Vehicle> vehicle;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	


	public Customer(long id, String firstName, String lastName, String email, String contactNumber, String gender,
			Date dateOfBirth, String address, String nationality, String licenceNumber, List<Vehicle> vehicle) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.nationality = nationality;
		this.licenceNumber = licenceNumber;
		this.vehicle = vehicle;
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

	public Customer(String nationality, String email, String gender) {
		this.nationality = nationality;
		this.email = email;
		this.gender = gender;

	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

