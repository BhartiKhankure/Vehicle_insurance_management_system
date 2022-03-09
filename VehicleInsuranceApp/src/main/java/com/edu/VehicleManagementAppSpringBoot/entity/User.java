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
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column
	private String email;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column
	private String username;
	@Column
	private String password;
	@Column(name = "confirm_password")
	private String confirmPassword;
	@Column
	private String gender;
	@Column(name="DoB")
	private Date dateOfBirth;
	@Column
	private String nationality;
	@Column
	private String role;
	@Column(name = "licence_number")
	private String licenceNumber;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Vehicle> vehicle;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * 
	 * public User(long id, String firstName, String lastName, String email, String
	 * contactNumber, String password, String confirmPassword, String gender, String
	 * nationality, String role, String licenceNumber) { super(); this.id = id;
	 * this.firstName = firstName; this.lastName = lastName; this.email = email;
	 * this.contactNumber = contactNumber; this.password = password;
	 * this.confirmPassword = confirmPassword; this.gender = gender;
	 * this.nationality = nationality; this.role = role; this.licenceNumber =
	 * licenceNumber; }
	 * 
	 * 
	 * public long getId() { return id; }
	 * 
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * 
	 * public String getContactNumber() { return contactNumber; }
	 * 
	 * 
	 * public void setContactNumber(String contactNumber) { this.contactNumber =
	 * contactNumber; }
	 * 
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * 
	 * public String getConfirmPassword() { return confirmPassword; }
	 * 
	 * 
	 * public void setConfirmPassword(String confirmPassword) { this.confirmPassword
	 * = confirmPassword; }
	 * 
	 * 
	 * public String getGender() { return gender; }
	 * 
	 * 
	 * public void setGender(String gender) { this.gender = gender; }
	 * 
	 * 
	 * public String getNationality() { return nationality; }
	 * 
	 * 
	 * public void setNationality(String nationality) { this.nationality =
	 * nationality; }
	 * 
	 * 
	 * public String getRole() { return role; }
	 * 
	 * 
	 * public void setRole(String role) { this.role = role; }
	 * 
	 * 
	 * public String getLicenceNumber() { return licenceNumber; }
	 * 
	 * 
	 * public void setLicenceNumber(String licenceNumber) { this.licenceNumber =
	 * licenceNumber; }
	 * 
	 * 
	 * @Override public String toString() { return "User [id=" + id + ", firstName="
	 * + firstName + ", lastName=" + lastName + ", email=" + email +
	 * ", contactNumber=" + contactNumber + ", password=" + password +
	 * ", confirmPassword=" + confirmPassword + ", gender=" + gender +
	 * ", nationality=" + nationality + ", role=" + role + ", licenceNumber=" +
	 * licenceNumber + "]"; }
	 * 
	 */

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public User(String nationality, String email, String gender) {
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User( List<Vehicle> vehicle) {
		
		this.vehicle = vehicle;
	}

}
