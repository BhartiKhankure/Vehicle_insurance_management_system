package com.edu.VehicleManagementAppSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.VehicleManagementAppSpringBoot.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

	List<User> findByFirstName(String firstName);

	@Query("select u from User u where u.firstName = :name") // Using JPQL Query Annotation
	List<User> findUserByFirstName(@Param("name") String firstName);

	@Query("Select u from User u ORDER BY u.firstName ASC")
	List<User> findOrderByFirstNameAsc(@Param("firstName") String firstName); // Using JPQL Query Annotation

	@Query("Select u from User u ORDER BY u.firstName DESC")
	List<User> findOrderByFirstNameDesc(@Param("firstName") String firstName); // Using JPQL Query Annotation

	@Query("Select u From User u WHERE u.firstName IN :firstName")
	List<User> findAllUserByFirstName(@Param("firstName") String firstName); // Using JPQL Query Annotation

	List<User> findByLastName(String lastName);

	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("Select u from User u where u.firstName = :firstName and u.lastName =  :lastName")
	List<User> findUserByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName); // Using
																															// JPQL
																															// Query
																															// Annotation

	List<User> findByFirstNameOrLastName(String firstName, String lastName);

	@Query("Select u from User u where u.firstName = :firstName or u.lastName = :lastName")
	List<User> findUserByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName); // Using
																														// JPQL
																														// Query
																														// Annotation

	List<User> findByFirstNameOrEmail(String firstName, String email);

	// Using Constructor
	@Query("Select new com.edu.VehicleManagementAppSpringBoot.entity.User(u.firstName, u.lastName) from User u where u.id = :id") // Using
																																	// Constructor
	User findUserFullNameById(@Param("id") long id);

	//@Query("Select new com.edu.VehicleManagementAppSpringBoot.entity.User(u.nationality, u.email, u.gender) from User u where u.id = :id") // Using
																																			// Constructor
	User findUserNationalityEmailGenderById(@Param("id") long id);

	@Query("Select COUNT(u.id) FROM User u ORDER BY u.firstName DESC")
	List<User> findUserInOrderDesc();

	User save(User user);

	long getIdByEmail(String userEmail);



	

//	 @Query("select new com.edu.VehicleManagementAppSpringBoot.entity.User(count(id), u.vehicle_id, v.plateNumber) from User u , Vehicle v GROUP BY u.vehicle_id")
//	 List<User> findUserByVehicleGroup();

}

