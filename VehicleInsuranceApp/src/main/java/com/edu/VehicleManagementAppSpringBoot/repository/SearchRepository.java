package com.edu.VehicleManagementAppSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.VehicleManagementAppSpringBoot.entity.Search;

public interface SearchRepository extends JpaRepository<Search, Long> {

}
