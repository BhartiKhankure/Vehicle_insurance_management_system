package com.edu.VehicleManagementAppSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_address")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long id;
	@Column(name = "plot_number")
	private String plotNumber;
	@Column(name = "near_by")
	private String nearBy;
	@Column
	private String area;
	@Column
	private String city;
	@Column
	private String state;
	@Column(name = "zip_code")
	private String zipCode;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(long id, String plotNumber, String nearBy, String area, String city, String state,
			String zipCode) {
		super();
		this.id = id;
		this.plotNumber = plotNumber;
		this.nearBy = nearBy;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}

	public String getNearBy() {
		return nearBy;
	}

	public void setNearBy(String nearBy) {
		this.nearBy = nearBy;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", plotNumber=" + plotNumber + ", nearBy=" + nearBy + ", area=" + area
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

}
