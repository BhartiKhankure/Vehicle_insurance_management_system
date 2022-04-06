package com.edu.VehicleManagementAppSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/bulkUser")
	public String addUser(@RequestBody List<User> user) {
		if (user != null && !user.isEmpty()) {
			userService.insertAll(user);
			return String.format("Added Customers.", user.size());
		} else {
			return REQUEST_NO_BODY;
		}
	}
	
	//display list of users

//	@GetMapping("/")
//	public String viewUserList(Model model) {
//		model.addAttribute("listUsers", userService.getAllUser());
//		return "index";
//	}

	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/userByFirstName/{firstName}")
	public List<User> getUserByFirstName(@PathVariable("firstName") String firstName) {
		return userService.getUserByFirstName(firstName);
	}
	
	@GetMapping("/userByEmail")
	public Optional<User> getUserByEmail(@PathVariable("email") String email){
		return userService.getUserByEmail(email);
	}

	@GetMapping("/userByLastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable("lastName") String lastName) {
		return userService.getUserByLastName(lastName);
	}

	@GetMapping("/userByFirstNameAndLastName") // using by JPQL
	public List<User> getUserByFirstNameAndLastName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		return userService.getUserByFirstNameAndLastName(firstName, lastName);
	}

	@GetMapping("userByFirstNameOrLastName")
	public List<User> getUserByFirstNameOrLastName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		return userService.getUserByFirstNameOrLastName(firstName, lastName);
	}

	@GetMapping("/userByFirstNameOrEmail")
	public List<User> getUserByFirstNameOrGender(@RequestParam("firstName") String firstName,
			@RequestParam("email") String email) {
		return userService.getUserByFirstNameOrEmail(firstName, email);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Record Is Deleted", HttpStatus.OK);
	}

	@PatchMapping("{id}")
	public ResponseEntity<User> updateUserPartially(@PathVariable("id") long id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUserPartially(user, id), HttpStatus.OK);

	}

	@GetMapping("/userInOrderDesc")
	public List<User> getUserInOrderDesc() {
		return userService.getUserInOrderDesc();
	}

	@GetMapping("/userFullNameById/{id}")
	public User getUserFullNameById(@PathVariable("id") long id) {
		return userService.getUserFullNameById(id);
	}

	

//		@GetMapping("/userByVehicleGroup")
//		public List<User> getUserByVehicleGroup(){
//			return userService.getUserByVehicleGroup();
//		}
	
	 

}
