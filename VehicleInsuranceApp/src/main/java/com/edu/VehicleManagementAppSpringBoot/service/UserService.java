package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.Optional;

import com.edu.VehicleManagementAppSpringBoot.entity.User;



public interface UserService {
   public Optional<User> findUserByUserName(String userName);
   
}