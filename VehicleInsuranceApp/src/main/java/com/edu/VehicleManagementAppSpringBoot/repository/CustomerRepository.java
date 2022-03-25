package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.VehicleManagementAppSpringBoot.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName);

	@Query("select c from Customer c where c.firstName = :name") // Using JPQL Query Annotation
	List<Customer> findCustomerByFirstName(@Param("name") String firstName);

	@Query("Select c from Customer c ORDER BY c.firstName ASC")
	List<Customer> findOrderByFirstNameAsc(@Param("firstName") String firstName); // Using JPQL Query Annotation

	@Query("Select c from Customer c ORDER BY c.firstName DESC")
	List<Customer> findOrderByFirstNameDesc(@Param("firstName") String firstName); // Using JPQL Query Annotation

	@Query("Select c From Customer c WHERE c.firstName IN :firstName")
	List<Customer> findAllCustomerByFirstName(@Param("firstName") String firstName); // Using JPQL Query Annotation

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("Select c from Customer c where c.firstName = :firstName and c.lastName =  :lastName")
	List<Customer> findCustomerByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName); // Using
																															// JPQL
																															// Query
																															// Annotation

	List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

	@Query("Select c from Customer c where c.firstName = :firstName or c.lastName = :lastName")
	List<Customer> findCustomerByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName); // Using
																														// JPQL
																														// Query
																														// Annotation

	List<Customer> findByFirstNameOrEmail(String firstName, String email);

	// Using Constructor
	@Query("Select new com.edu.VehicleManagementAppSpringBoot.entity.Customer(c.firstName, c.lastName) from Customer c where c.id = :id") // Using
																																	// Constructor
	Customer findCustomerFullNameById(@Param("id") long id);

	@Query("Select new com.edu.VehicleManagementAppSpringBoot.entity.Customer(c.nationality, c.email, c.gender) from Customer c where c.id = :id") // Using
																																			// Constructor
	Customer findCustomerNationalityEmailGenderById(@Param("id") long id);

	@Query("Select COUNT(c.id) FROM Customer c ORDER BY c.firstName DESC")
	List<Customer> findCustomerInOrderDesc();

	

//	 @Query("select new com.edu.VehicleManagementAppSpringBoot.entity.User(count(id), u.vehicle_id, v.plateNumber) from User u , Vehicle v GROUP BY u.vehicle_id")
//	 List<User> findUserByVehicleGroup();

}

