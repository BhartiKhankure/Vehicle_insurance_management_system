package com.edu.VehicleManagementAppSpringBoot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "insurance_tbl")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insurance_id")
	private long id;
	@Column(name = "insurance_provider")
	private String insuranceProvider;
	@Column(name = "insurance_number", unique = true)
	private String insuranceNumber;
	@Column(name = "insurance_validity")
	private String insuranceValidity;
	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(long id, String insuranceProvider, String insuranceNumber, String insuranceValidity) {
		super();
		this.id = id;
		this.insuranceProvider = insuranceProvider;
		this.insuranceNumber = insuranceNumber;
		this.insuranceValidity = insuranceValidity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", insuranceProvider=" + insuranceProvider + ", insuranceNumber="
				+ insuranceNumber + ", insuranceValidity=" + insuranceValidity + "]";
	}

}
