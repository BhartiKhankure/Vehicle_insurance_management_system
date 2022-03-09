package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByManufacturer(String manufacturer);

	List<Vehicle> findByPendingFines(double pendingFines);

	List<Vehicle> findByCategory(String category);

	@Query("select v from Vehicle v where v.category = :category") // Using JPQL Query Annotation
	List<User> findVehicleByCategory(@Param("category") String category);

	List<Vehicle> findByType(String type);

}
