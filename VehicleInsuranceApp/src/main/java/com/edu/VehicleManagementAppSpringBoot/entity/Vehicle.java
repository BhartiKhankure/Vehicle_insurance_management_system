package com.edu.VehicleManagementAppSpringBoot.entity;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

//@Data
@Entity
@Table(name = "vehicle_tbl")
public class Vehicle {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veh_id")
	private long id;
	
	@NotNull
	@NotBlank(message="Category can't be Empty")
	@Column
	private String category;
	
	@NotNull
	@NotBlank(message="Plate Number can't be Empty")
	@Column(name = "plate_number" , unique=true)
	private String plateNumber;
	
	@NotNull
	@NotBlank(message="Manufacturer can't be Empty")
	@Column
	private String manufacturer;
	
	@NotNull
	@NotBlank(message="Type can't be Empty")
	@Column
	private String type;
	
	@NotNull
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	@NotNull
	@Column(name = "premiumAmount")
	private double premiumAmount;
	
	@NotNull
    @Column(name="next_premium_date")
    private LocalDate nextPreDate;
	
	@NotNull
    @Column(name="previous_premium_date")
    private LocalDate previousPreDate;
	
	@NotNull
    @Column
    private int pendingFines;
    
	@OneToOne
	@JoinColumn(name = "insurance_id")
	private Insurance insurance;

	@ManyToOne
	 @JsonManagedReference
	 @JoinColumn(name = "user_id")
	//@JoinTable(name = "vehicle_user", joinColumns = { @JoinColumn(name = "veh_id") }, inverseJoinColumns = {
	//		@JoinColumn(name = "user_id") })
	public User user;
	


	
	public Vehicle(long id, @NotNull @NotBlank(message = "Category can't be Empty") String category,
			@NotNull @NotBlank(message = "Plate Number can't be Empty") String plateNumber,
			@NotNull @NotBlank(message = "Manufacturer can't be Empty") String manufacturer,
			@NotNull @NotBlank(message = "Type can't be Empty") String type, @NotNull LocalDate registrationDate,
			@NotNull double premiumAmount, @NotNull LocalDate nextPreDate, @NotNull LocalDate previousPreDate,
			@NotNull int pendingFines, Insurance insurance, User user) {
		super();
		this.id = id;
		this.category = category;
		this.plateNumber = plateNumber;
		this.manufacturer = manufacturer;
		this.type = type;
		this.registrationDate = registrationDate;
		this.premiumAmount = premiumAmount;
		this.nextPreDate = nextPreDate;
		this.previousPreDate = previousPreDate;
		this.pendingFines = pendingFines;
		this.insurance = insurance;
		this.user = user;
	}

	public Vehicle() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Vehicle(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public LocalDate getNextPreDate() {
		return nextPreDate;
	}

	public void setNextPreDate(LocalDate nextPreDate) {
		this.nextPreDate = nextPreDate;
	}

	public LocalDate getPreviousPreDate() {
		return previousPreDate;
	}

	public void setPreviousPreDate(LocalDate previousPreDate) {
		this.previousPreDate = previousPreDate;
	}

	public int getPendingFines() {
		return pendingFines;
	}

	public void setPendingFines(int pendingFines) {
		this.pendingFines = pendingFines;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", category=" + category + ", plateNumber=" + plateNumber + ", manufacturer="
				+ manufacturer + ", type=" + type + ", registrationDate=" + registrationDate + ", premiumAmount="
				+ premiumAmount + ", nextPreDate=" + nextPreDate + ", previousPreDate=" + previousPreDate
				+ ", pendingFines=" + pendingFines + ", insurance=" + insurance + ", user=" + user + "]";
	}
	

	public void setUser(Optional<User> findById) {
		
	}
	
	
	

	
	
}