package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.VehicleManagementAppSpringBoot.entity.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

	List<UserAddress> findByPlotNumber(String plotNumber);

	List<UserAddress> findByArea(String area);

	List<UserAddress> findByCity(String city);

}
