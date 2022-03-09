package com.edu.VehicleManagementAppSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.VehicleManagementAppSpringBoot.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
