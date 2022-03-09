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
	// @JoinColumn(name = "user_id")
	@JoinTable(name = "vehicle_user", joinColumns = { @JoinColumn(name = "veh_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private User user;

	public Vehicle() {
		super();
		
	}

	public Vehicle(long id, String category, String plateNumber, String manufacturer, String type, String color,
			Date registrationDate, double pendingFines) {
		super();
		this.id = id;
		this.category = category;
		this.plateNumber = plateNumber;
		this.manufacturer = manufacturer;
		this.type = type;
		this.color = color;
		this.registrationDate = registrationDate;
		this.pendingFines = pendingFines;
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

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", category=" + category + ", plateNumber=" + plateNumber + ", manufacturer="
				+ manufacturer + ", type=" + type + ", color=" + color + ", registrationDate=" + registrationDate
				+ ", pendingFines=" + pendingFines + "]";
	}

}
