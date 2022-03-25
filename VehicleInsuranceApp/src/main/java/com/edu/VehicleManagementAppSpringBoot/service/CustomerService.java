package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.List;


import com.edu.VehicleManagementAppSpringBoot.entity.Customer;



public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> insertAll(List<Customer> customer);

	List<Customer> getAllCustomer();

	Customer getCustomerById(long id);

	List<Customer> getCustomerByFirstName(String firstName);

	List<Customer> getCustomerByLastName(String lastName);

	List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName);

	List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName);

	Customer updateCustomer(Customer customer, long id);

	void deleteCustomer(long id);

	Customer updateCustomerPartially(Customer customer, long id);

	List<Customer> getCustomerInOrderDesc();

	Customer getCustomerFullNameById(long id);

	Customer getCustomerNationalityEmailGenderById(long id);

	List<Customer> getCustomerByFirstNameOrEmail(String firstName, String email);

	

	 

	// List<User> getUserByVehicleGroup();

}
