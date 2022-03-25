package com.edu.VehicleManagementAppSpringBoot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "vehicle_tbl")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veh_id")
	private long id;
	

	@Column
	private String category;
	
	
	@Column(name = "plate_number")
	private String plateNumber;
	
	
	@Column
	private String manufacturer;
	

	@Column
	private String type;
	

	@Column
	private String color;
	

	@Column(name = "registration_date")
	private Date registrationDate;
	
	
	@Column(name = "pending_fines")
	private double pendingFines;

	@OneToOne
	@JoinColumn(name = "insurance_id")
	private Insurance insurance;

	@ManyToOne
	@JsonManagedReference
	 @JoinColumn(name = "customer_id")
	//@JoinTable(name = "vehicle_user", joinColumns = { @JoinColumn(name = "veh_id") }, inverseJoinColumns = {
	//		@JoinColumn(name = "customer_id") })
	private Customer customer;

	public Vehicle() {
		super();
		
	}

	public Vehicle(long id,
			@NotBlank(message = "Category can't be Empty") @NotNull(message = "Please enter the category ") String category,
			@NotBlank(message = "Plate number can't be Empty") @NotNull(message = "Please enter plate number") String plateNumber,
			@NotBlank(message = "Manufacturer can't be Empty") @NotNull(message = "Please enter manufacturer ") String manufacturer,
			@NotBlank(message = "type can't be Empty") @NotNull(message = "Please enter the type ") String type,
			@NotBlank(message = "Color can't be Empty") @NotNull(message = "Please enter the color ") String color,
			@Past Date registrationDate,
			@NotBlank(message = "Pending fines can't be Empty") @NotNull(message = "Please enter pending fines ") double pendingFines,
			Insurance insurance, Customer customer) {
		super();
		this.id = id;
		this.category = category;
		this.plateNumber = plateNumber;
		this.manufacturer = manufacturer;
		this.type = type;
		this.color = color;
		this.registrationDate = registrationDate;
		this.pendingFines = pendingFines;
		this.insurance = insurance;
		this.customer = customer;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public double getPendingFines() {
		return pendingFines;
	}

	public void setPendingFines(double pendingFines) {
		this.pendingFines = pendingFines;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
