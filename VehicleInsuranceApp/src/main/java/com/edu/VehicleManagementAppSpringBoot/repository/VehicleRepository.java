package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByManufacturer(String manufacturer);

	List<Vehicle> findByPendingFines(double pendingFines);

	Optional<Vehicle> findByCategory(String category);

	@Query("select v from Vehicle v where v.category = :category") // Using JPQL Query Annotation
	List<Vehicle> findVehicleByCategory(@Param("category") String category);

	List<Vehicle> findByType(String type);

	List<Vehicle> findVehiclesByUserId(long id);


}
