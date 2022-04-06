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

import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;
import com.edu.VehicleManagementAppSpringBoot.service.InsuranceService;

@RestController
@RequestMapping("/api/insuranceManagement")
public class InsuranceController {

	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private InsuranceService insuranceService;

	public InsuranceController(InsuranceService insuranceService) {
		super();
		this.insuranceService = insuranceService;
	}

	@PostMapping
	public ResponseEntity<Insurance> saveInsurance(@RequestBody Insurance insurance) {
		return new ResponseEntity<Insurance>(insuranceService.saveInsurance(insurance), HttpStatus.CREATED);
	}

	@PostMapping("/bulkInsurance")
	public String addInsurance(@RequestBody List<Insurance> insurance) {
		if (insurance != null && !insurance.isEmpty()) {
			insuranceService.insertAll(insurance);
			return String.format("Added insurances.", insurance.size());
		} else {
			return REQUEST_NO_BODY;
		}
	}

	@GetMapping
	public List<Insurance> getAllInsurance() {
		return insuranceService.getAllInsurance();
	}

	@GetMapping("{id}")
	public ResponseEntity<Insurance> getInsuranceById(@PathVariable("id") long id) {
		return new ResponseEntity<Insurance>(insuranceService.getInsuranceById(id), HttpStatus.OK);

	}

	@GetMapping("/insuranceByInsuranceProvider/{insuranceProvider}")
	public List<Insurance> getInsuranceByInsuranceProvider(
			@PathVariable("insuranceProvider") String insuranceProvider) {
		return insuranceService.getInsuranceByInsuranceProvider(insuranceProvider);
	}

	@GetMapping("/insuranceByInsuranceNumber/{insuranceNumber}")
	public Optional<Insurance> getInsuranceByInsuranceNumber(@PathVariable("insuranceNumber") String insuranceNumber) {
		return insuranceService.getInsuranceByInsuranceNumber(insuranceNumber);
	}

	@PutMapping("{id}")
	public ResponseEntity<Insurance> updateInsurance(@PathVariable("id") long id, @RequestBody Insurance insurance) {
		return new ResponseEntity<Insurance>(insuranceService.updateInsurance(insurance, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteInsurance(@PathVariable("id") long id) {
		insuranceService.deleteInsurance(id);
		return new ResponseEntity<String>("Insurance record deleted", HttpStatus.OK);

	}

	@PatchMapping("{id}")
	public ResponseEntity<Insurance> updateInsurancePartially(@PathVariable("id") long id,
			@RequestBody Insurance insurance) {
		return new ResponseEntity<Insurance>(insuranceService.updateInsurancePartially(insurance, id), HttpStatus.OK);

	}

}
