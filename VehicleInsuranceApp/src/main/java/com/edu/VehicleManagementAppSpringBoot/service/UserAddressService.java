package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.List;

import com.edu.VehicleManagementAppSpringBoot.entity.UserAddress;

public interface UserAddressService {

	UserAddress saveUserAddress(UserAddress userAddress);

	List<UserAddress> getAllUserAddress();

	UserAddress getUserAddressById(long id);

	UserAddress updateUserAddress(UserAddress userAddress, long id);

	void deleteUserAddress(long id);

	UserAddress updateUserAddressPartially(UserAddress userAddress, long id);

	List<UserAddress> insertAll(List<UserAddress> userAddress);

	List<UserAddress> getUserAddressByArea(String area);

	List<UserAddress> getUserAddressByPlotNumber(String plotNumber);

	List<UserAddress> getUserAddressByCity(String city);

}
