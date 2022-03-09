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
import org.springframework.web.bind.annotation.RestController;

import com.edu.VehicleManagementAppSpringBoot.entity.UserAddress;
import com.edu.VehicleManagementAppSpringBoot.service.UserAddressService;

@RestController
@RequestMapping("/api/userAddress")
public class UserAddressController {
	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private UserAddressService userAddressService;

	public UserAddressController(UserAddressService userAddressService) {
		super();
		this.userAddressService = userAddressService;
	}

	@PostMapping
	public ResponseEntity<UserAddress> saveUserAddress(@RequestBody UserAddress userAddress) {
		return new ResponseEntity<UserAddress>(userAddressService.saveUserAddress(userAddress), HttpStatus.CREATED);

	}

	@PostMapping("/bulkUserAddress")
	public String addUserAddress(@RequestBody List<UserAddress> userAddress) {
		if (userAddress != null && !userAddress.isEmpty()) {
			userAddressService.insertAll(userAddress);
			return String.format("Added userAddresses.", userAddress.size());
		} else {
			return REQUEST_NO_BODY;
		}
	}

	@GetMapping
	public List<UserAddress> getAllUserAddress() {
		return userAddressService.getAllUserAddress();
	}

	@GetMapping("{id}")
	public ResponseEntity<UserAddress> getUserAddressById(@PathVariable("id") long id) {
		return new ResponseEntity<UserAddress>(userAddressService.getUserAddressById(id), HttpStatus.OK);

	}

	@GetMapping("/userAddressByPlotNumber/{plotNumber}")
	public List<UserAddress> getUserAddressByPlotNumber(@PathVariable("plotNumber") String plotNumber) {
		return userAddressService.getUserAddressByPlotNumber(plotNumber);
	}

	@GetMapping("/userAddressByArea/{area}")
	public List<UserAddress> getUserAddressByArea(@PathVariable("area") String area) {
		return userAddressService.getUserAddressByArea(area);
	}

	@GetMapping("/userAddressByCity/{city}")
	public List<UserAddress> getUserAddressByCity(@PathVariable("city") String city) {
		return userAddressService.getUserAddressByCity(city);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserAddress> updateUserAddress(@PathVariable("id") long id,
			@RequestBody UserAddress userAddress) {
		return new ResponseEntity<UserAddress>(userAddressService.updateUserAddress(userAddress, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUserAddress(@PathVariable("id") long id) {
		userAddressService.deleteUserAddress(id);
		return new ResponseEntity<String>("UserAddress record deleted", HttpStatus.OK);

	}

	@PatchMapping("{id}")
	public ResponseEntity<UserAddress> updateUserAddressPartially(@PathVariable("id") long id,
			@RequestBody UserAddress userAddress) {
		return new ResponseEntity<UserAddress>(userAddressService.updateUserAddressPartially(userAddress, id),
				HttpStatus.OK);

	}

}
