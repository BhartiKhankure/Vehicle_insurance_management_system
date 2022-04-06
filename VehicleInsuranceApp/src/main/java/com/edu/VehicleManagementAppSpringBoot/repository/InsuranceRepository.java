package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

	List<Insurance> findByinsuranceProvider(String insuranceProvider);

	Optional<Insurance> findByInsuranceNumber(String insuranceNumber);

}
