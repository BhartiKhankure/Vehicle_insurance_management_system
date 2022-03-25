package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.List;

import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;

public interface VehicleService {

	Vehicle saveVehicle(Vehicle vehicle);

	List<Vehicle> getAllVehicle();

	Vehicle getVehicleById(long id);

	List<Vehicle> getVehicleByManufacturer(String manufacturer);

	List<Vehicle> getVehicleByPendingFines(double pendingFines);

	Vehicle updateVehicle(Vehicle vehicle, long id);

	void deleteVehicle(long id);

	List<Vehicle> insertAll(List<Vehicle> vehicle);

	Vehicle updateVehiclePartially(Vehicle vehicle, long id);

	List<Vehicle> getVehicleByCategory(String category);

	List<Vehicle> getVehicleByType(String type);

}