package com.edu.VehicleManagementAppSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search_tbl")
public class Search {
	@Id
	@Column(name = "search_id")
	private long id;
	@Column
	private String username;
	@Column(name = "licence_number")
	private String licenceNumber;
	@Column(name = "plate_number")
	private String plateNumber;
	@Column(name = "insurance_number")
	private String insuranceNumber;
	/*
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "veh_id")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name = "insurance_id")
	private Insurance insurance;
*/
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Search(String username, String licenceNumber, String plateNumber, String insuranceNumber) {
		super();
		this.username = username;
		this.licenceNumber = licenceNumber;
		this.plateNumber = plateNumber;
		this.insuranceNumber = insuranceNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

}
