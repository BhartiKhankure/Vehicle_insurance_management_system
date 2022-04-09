package com.edu.VehicleManagementAppSpringBoot;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;
import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;
import com.edu.VehicleManagementAppSpringBoot.service.InsuranceService;
import com.edu.VehicleManagementAppSpringBoot.service.UserService;
import com.edu.VehicleManagementAppSpringBoot.service.VehicleService;



@Controller
public class UIController {
	private UserService userService;
	private VehicleService vehicleService;
	private InsuranceService insuranceService;

	
	
	@Autowired
	public UIController(UserService userService, VehicleService vehicleService, InsuranceService insuranceService) {
		super();
		this.userService = userService;
		this.vehicleService = vehicleService;
		this.insuranceService = insuranceService;
		
	}
	
	@GetMapping("/")
		public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//For user registration
	@GetMapping("/registration")
	public String RegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
	@PostMapping("/saveUser")
	public String saveUser(@Valid  User user, BindingResult result , Model model) {
		if (result.hasErrors()) {
		    return "registration";
		  }else {
	    userService.saveUser(user);
	    List<User> users =  userService.getAllUser();
	    model.addAttribute("successMessage", "Details are saved successfully");
	    getAllUser(model);
		}
	    return "redirect:/getUsers";
	    
	}
	
	@GetMapping("/getUsers")
	public String getAllUser(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "list-user";
	}
	
	
	
	//For Vehicle
	@GetMapping("/vehicleForm")
	public String vehicleDetailsForm(Model model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		return "add-vehicle";
	}
	
	
	@PostMapping("/saveVehicle")
	public String saveVehicle(@Valid  Vehicle vehicle, BindingResult result , Model model) {
		if (result.hasErrors()) {
		    return "add-vehicle";
		  }else {
	    vehicleService.saveVehicle(vehicle);
	   // List<Vehicle> vehicles =  vehicleService.getAllVehicle();
	    model.addAttribute("successMessage", "Details are saved successfully");
	    getAllVehicle(model);
		}
	    return "redirect:/getVehicles";
	    
	}

	
	@GetMapping("/getVehicles")
	public String getAllVehicle(Model model) {
		List<Vehicle> vehicles = vehicleService.getAllVehicle();
		model.addAttribute("vehicles", vehicles);
		return "list-vehicle";
	}
	
	
	@GetMapping("/vehicles/editVehicle/{id}")
	public String updateFormVehicle(@PathVariable(value="id" )long id,  Model model)
	{
		Vehicle vehicle=vehicleService.getVehicleById(id);
		model.addAttribute("vehicle",vehicle);
		return "update-vehicle";
	}
		@PostMapping("/vehicles/editVehicle")
		public String updateVehicle(@PathVariable(value="id" )long id, @ModelAttribute Vehicle vehicle, Model model) {
			vehicleService.updateVehicle(vehicle, id);
			model.addAttribute("message","record updated successfully");
			getAllVehicle(model);
			return null;
		}
	
	//For Insurance
	@GetMapping("/insuranceForm")
	public String insuranceDetailsForm(Model model) {
		Insurance insurance = new Insurance();
		model.addAttribute("insurance", insurance);
		return "add-insurance";
	}
	
	
	@PostMapping("/saveInsurance")
	public String saveInsurance(@Valid  Insurance insurance, BindingResult result , Model model) {
		if (result.hasErrors()) {
		    return "add-insurance";
		  }else {
	    insuranceService.saveInsurance(insurance);
	    List<Insurance> insurances =  insuranceService.getAllInsurance();
	    model.addAttribute("successMessage", "Details are saved successfully");
	    getAllInsurance(model);
		}
	    return "redirect:/getInsurances";
	    
	}

	
	@GetMapping("/getInsurances")
	public String getAllInsurance(Model model) {
		List<Insurance> insurances = insuranceService.getAllInsurance();
		model.addAttribute("insurances", insurances);
		return "list-insurance";
	}
		
	
	
	
	
	//------------------------------------For Edit And Delete Operation-----------------------------------
	
	//Edit Customer
	@GetMapping("/users/editUser/{id}")
	public String edituserById(Model model, @PathVariable("id") long id) 
							
	{
	System.out.println("editUserById" + id);
	User user = userService.getUserById(id);
			model.addAttribute("user", user);
		return "update-user";
	}
	
	
	//For Delete Customer
	@GetMapping("/users/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable("id") Long id) 
							
	{
		
		System.out.println("deleteUser" + id);
		
		userService.deleteUser(id);
		return "redirect:/";
	}
	
	
		//For Delete Vehicle`
		@GetMapping("/vehicles/deleteVehicle/{id}")
		public String deleteVehicle(Model model, @PathVariable("id") Long id) 
								
		{
			
			System.out.println("deleteVehicle" + id);
			
			vehicleService.deleteVehicle(id);
			return "redirect:/";
		}
		
		
		//Edit Insurance
		@GetMapping("/insurances/editInsurance/{id}")
		public String editInsuranceById(Model model, @PathVariable("id") long id) 
								
		{
		System.out.println("editInsuranceById" + id);
		Insurance insurance = insuranceService.getInsuranceById(id);
				model.addAttribute("insurance", insurance);
			return "update-insurance";
		}
		
		
		//For Delete Insurance
		@GetMapping("/insurances/deleteInsurance/{id}")
		public String deleteInsurance(Model model, @PathVariable("id") Long id) 
							
		{
			
			System.out.println("deleteInsurance" + id);
			
			insuranceService.deleteInsurance(id);
			return "redirect:/";
		}


		@GetMapping("/user/userAccount")
		public String userAccount(Model model) {
			Vehicle vehicle = new Vehicle();
			model.addAttribute("vehicle", vehicle);
			return "user-account";
		}
		
		@PostMapping("/userAccount")
		public String saveAccountVehicle(@Valid Vehicle vehicle, Errors errors, Model model) {
			if(null != errors && errors.getErrorCount() > 0)
				return "redirect:/";
			else {
				vehicleService.saveVehicle(vehicle);
				List<Vehicle> vehicles = vehicleService.getAllVehicle();
				model.addAttribute("successMessage", "Details are saved successfully");
			}
			return "add-user-account";
		}
		
		public String currentUser() {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String userEmail;
			if (principal instanceof UserDetails) {
			    userEmail = ((UserDetails)principal).getUsername();
			} else {
			     userEmail = null;
			}
	       return userEmail;
		}
		
			

			@GetMapping("/logout")
			public String logout() {
				return "/";
			}
	
}