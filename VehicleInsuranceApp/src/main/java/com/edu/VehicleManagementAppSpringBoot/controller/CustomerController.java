package com.edu.VehicleManagementAppSpringBoot.controller;

import java.util.List;

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

import com.edu.VehicleManagementAppSpringBoot.entity.Customer;
import com.edu.VehicleManagementAppSpringBoot.service.CustomerService;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}

	@PostMapping("/bulkCustomer")
	public String addCustomer(@RequestBody List<Customer> customer) {
		if (customer != null && !customer.isEmpty()) {
			customerService.insertAll(customer);
			return String.format("Added Customers.", customer.size());
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
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	@GetMapping("/customerByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName) {
		return customerService.getCustomerByFirstName(firstName);
	}

	@GetMapping("/customerByLastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName") String lastName) {
		return customerService.getCustomerByLastName(lastName);
	}

	@GetMapping("/userByFirstNameAndLastName") // using by JPQL
	public List<Customer> getUserByFirstNameAndLastName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		return customerService.getCustomerByFirstNameAndLastName(firstName, lastName);
	}

	@GetMapping("/customerByFirstNameOrLastName")
	public List<Customer> getCustomerByFirstNameOrLastName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		return customerService.getCustomerByFirstNameOrLastName(firstName, lastName);
	}

	@GetMapping("/customerByFirstNameOrEmail")
	public List<Customer> getCustomerByFirstNameOrGender(@RequestParam("firstName") String firstName,
			@RequestParam("email") String email) {
		return customerService.getCustomerByFirstNameOrEmail(firstName, email);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer Record Is Deleted", HttpStatus.OK);
	}

	@PatchMapping("{id}")
	public ResponseEntity<Customer> updateCustomerPartially(@PathVariable("id") long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomerPartially(customer, id), HttpStatus.OK);

	}

	@GetMapping("/customerInOrderDesc")
	public List<Customer> getCustomerInOrderDesc() {
		return customerService.getCustomerInOrderDesc();
	}

	@GetMapping("/customerFullNameById/{id}")
	public Customer getCustomerFullNameById(@PathVariable("id") long id) {
		return customerService.getCustomerFullNameById(id);
	}

	@GetMapping("customerNationalityEmailGenderById/{id}")
	public Customer getCustomerNationalityEmailGenderById(@PathVariable("id") long id) {
		return customerService.getCustomerNationalityEmailGenderById(id);
	}

//		@GetMapping("/userByVehicleGroup")
//		public List<User> getUserByVehicleGroup(){
//			return userService.getUserByVehicleGroup();
//		}

}
