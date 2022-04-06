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
import org.springframework.web.bind.annotation.RestController;

import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;
import com.edu.VehicleManagementAppSpringBoot.service.VehicleService;

@RestController
@RequestMapping("/api/vehicleManagement")
public class VehicleController {

	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}

	@PostMapping
	public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);

	}
	
	

	@PostMapping("/bulkVehicle")
	public String addVehicle(@RequestBody List<Vehicle> vehicle) {
		if (vehicle != null && !vehicle.isEmpty()) {
			vehicleService.insertAll(vehicle);
			return String.format("Added vehicles.", vehicle.size());
		} else {
			return REQUEST_NO_BODY;
		}
	}
	
	//display list of Vehicles

//	@GetMapping("/")
//	public String viewVehicleDetails(Model model) {
//		model.addAttribute("VehicleDetails", vehicleService.getAllVehicle());
//		return "vehicleRecord";
//	}

	@GetMapping
	public List<Vehicle> getAllVehicle() {
		return vehicleService.getAllVehicle();
	}

	@GetMapping("{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") long id) {
		return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);

	}

	@GetMapping("/vehicleByManufacturer/{manufacturer}")
	public List<Vehicle> getVehicleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
		return vehicleService.getVehicleByManufacturer(manufacturer);
	}

	@GetMapping("/vehicleByPendingFines/{pendingFines}")
	public List<Vehicle> getVehicleByPendingFines(@PathVariable("pendingFines") double pendingFines) {
		return vehicleService.getVehicleByPendingFines(pendingFines);
	}

	@GetMapping("/vehicleByCategory/{category}")
	public Optional<Vehicle> getVehicleByCategory(@PathVariable("category") String category) {
		return vehicleService.getVehicleByCategory(category);
	}

	@GetMapping("/vehicleByType/{type}")
	public List<Vehicle> getVehicleByType(@PathVariable("type") String type) {
		return vehicleService.getVehicleByType(type);
	}

	@PutMapping("{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicle(vehicle, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") long id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<String>("Vehicle record deleted", HttpStatus.OK);

	}

	@PatchMapping("{id}")
	public ResponseEntity<Vehicle> updateVehiclePartially(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehiclePartially(vehicle, id), HttpStatus.OK);

	}

}
