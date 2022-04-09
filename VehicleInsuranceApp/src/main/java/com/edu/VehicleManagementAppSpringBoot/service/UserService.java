package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.edu.VehicleManagementAppSpringBoot.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> insertAll(List<User> user);

	List<User> getAllUser();

	User getUserById(long id);

	List<User> getUserByFirstName(String firstName);

	List<User> getUserByLastName(String lastName);

	List<User> getUserByFirstNameAndLastName(String firstName, String lastName);

	List<User> getUserByFirstNameOrLastName(String firstName, String lastName);

	List<User> getUserByFirstNameOrEmail(String firstName, String email);

	User updateUser(User user, long id);

	void deleteUser(long id);

	User updateUserPartially(User user, long id);

	List<User> getUserInOrderDesc();

	User getUserFullNameById(long id);

	Optional<User> getUserByEmail(String email);

	long getIdByEmail(String userEmail);

}
