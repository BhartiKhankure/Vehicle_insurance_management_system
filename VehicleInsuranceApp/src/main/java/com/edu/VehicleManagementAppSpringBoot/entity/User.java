package com.edu.VehicleManagementAppSpringBoot.entity;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@NotBlank(message="First name can't be Empty")
	@Column(name = "first_name", nullable=true)
	private String firstName;
	
	
	@NotNull
	@NotBlank(message="Last name can't be Empty")
	@Column(name = "last_name" , nullable=true)
	private String lastName;
	
	@NotNull
	@NotBlank(message="Email can't be Empty")
	@Email
	@Column(nullable=false ,unique=true)
	private String email;
	
	@NotNull
	@NotBlank(message="Contact number can't be Empty")
	@Column(name = "contact_number", nullable=false, unique=true)
	private String contactNumber;
	
	@NotNull
	@NotBlank(message="Password can't be Empty")
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private static  String roles="ROLE_USER";
	
	@Column
	private static boolean active;
	
	@NotNull
	@NotBlank
	@Column(nullable=true)
	private String gender;
	
	@Column(nullable=true, name="dob")
	private LocalDate dateOfBirth;
	
	@NotNull
	@NotBlank(message="Address can't be Empty")
	@Column
	private String address;
	
	@NotNull
	@NotBlank(message="nationality can't be Empty")
	@Column(nullable=true)
	private String nationality;
	
	@NotNull
	@NotBlank(message="License number can't be Empty")
	@Column(name = "licence_number")
	private String licenceNumber;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Vehicle> vehicle;

	
		public User() {
		super();
		// TODO Auto-generated constructor stub
	}

		public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

		public User(long id, @NotNull @NotBlank(message = "First name can't be Empty") String firstName,
				@NotNull @NotBlank(message = "Last name can't be Empty") String lastName,
				@NotNull @NotBlank(message = "Email can't be Empty") @Email String email,
				@NotNull @NotBlank(message = "Contact number can't be Empty") String contactNumber,
				@NotNull @NotBlank(message = "Password can't be Empty") String password,boolean active,
				@NotNull @NotBlank String gender, LocalDate dateOfBirth,
				@NotNull @NotBlank(message = "Address can't be Empty") String address,
				@NotNull @NotBlank String nationality, @NotNull @NotBlank String licenceNumber, List<Vehicle> vehicle) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.contactNumber = contactNumber;
			this.password = password;
			User.active=isActive();
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.nationality = nationality;
			this.licenceNumber = licenceNumber;
			this.vehicle = vehicle;
		}

		public User(String string, String string2, String string3, String string4) {
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public static String getRoles() {
			return roles;
		}

		public static void setRoles(String roles) {
			User.roles = roles;
		}

		public static String isRoles() {
			// TODO Auto-generated method stub
			return roles="ROLE_ADMIN";
		}

		public static boolean isActive() {
			return active = "true" != null;
			
		}
		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
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

		public static void setActive(boolean active) {
			User.active = "true" != null;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", contactNumber=" + contactNumber + ", password=" + password + ", gender=" + gender
					+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", nationality=" + nationality
					+ ", licenceNumber=" + licenceNumber + ", vehicle=" + vehicle + "]";
		}

		
}
