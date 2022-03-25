package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.VehicleManagementAppSpringBoot.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);

}

