package com.edu.VehicleManagementAppSpringBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.VehicleManagementAppSpringBoot.entity.Admin;
import com.edu.VehicleManagementAppSpringBoot.service.AdminService;

@RestController
@RequestMapping("/api/adminManagement")
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@PostMapping
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);

	}

	@GetMapping
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@GetMapping("{Id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("Id") long Id) {
		return new ResponseEntity<Admin>(adminService.getAdminById(Id), HttpStatus.OK);

	}

	@PutMapping("{Id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("Id") long Id, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, Id), HttpStatus.OK);

	}

	@DeleteMapping("{Id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("Id") long Id) {
		adminService.deleteAdmin(Id);
		return new ResponseEntity<String>("Vehicle record deleted", HttpStatus.OK);

	}

}
