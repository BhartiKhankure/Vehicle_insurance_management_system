package com.edu.VehicleManagementAppSpringBoot;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.edu.VehicleManagementAppSpringBoot.entity.Customer;
import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;
import com.edu.VehicleManagementAppSpringBoot.entity.Search;
import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;
import com.edu.VehicleManagementAppSpringBoot.service.AdminService;
import com.edu.VehicleManagementAppSpringBoot.service.CustomerService;
import com.edu.VehicleManagementAppSpringBoot.service.InsuranceService;
import com.edu.VehicleManagementAppSpringBoot.service.SearchService;
import com.edu.VehicleManagementAppSpringBoot.service.VehicleService;


@Controller
public class UIController {
	private CustomerService customerService;
	private VehicleService vehicleService;
	private InsuranceService insuranceService;
	private SearchService searchService;
	private AdminService adminService;
	
	
	@Autowired
	public UIController(CustomerService customerService, VehicleService vehicleService, InsuranceService insuranceService, SearchService searchService, AdminService adminService) {
		super();
		this.customerService = customerService;
		this.vehicleService = vehicleService;
		this.insuranceService = insuranceService;
		this.searchService = searchService;
		this.adminService = adminService;
		
	}
	
	@GetMapping("/")
		public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//For Customer
	@GetMapping("/registration")
	public String CustomerDetailsForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid Customer customer, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			customerService.saveCustomer(customer);
			List<Customer> customers = customerService.getAllCustomer();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getCustomers";
	}
	
	@GetMapping("/getCustomers")
	public String getAllCustomer(Model model) {
		List<Customer> customers = customerService.getAllCustomer();
		model.addAttribute("customers", customers);
		return "list-customer";
	}
	
	//For Vehicle
	@GetMapping("/vehicleForm")
	public String vehicleDetailsForm(Model model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		return "add-vehicle";
	}
	
	@PostMapping("/saveVehicle")
	public String saveVehicle(@Valid Vehicle vehicle, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			vehicleService.saveVehicle(vehicle);
			List<Vehicle> vehicles = vehicleService.getAllVehicle();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getVehicles";
	}
	
	@GetMapping("/getVehicles")
	public String getAllVehicle(Model model) {
		List<Vehicle> vehicles = vehicleService.getAllVehicle();
		model.addAttribute("vehicles", vehicles);
		return "list-vehicle";
	}
	
	
	//For Insurance
	@GetMapping("/insuranceForm")
	public String insuranceDetailsForm(Model model) {
		Insurance insurance = new Insurance();
		model.addAttribute("insurance", insurance);
		return "add-insurance";
	}
	
	@PostMapping("/saveInsurance")
	public String saveInsurance(@Valid Insurance insurance, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			insuranceService.saveInsurance(insurance);
			List<Insurance> insurances = insuranceService.getAllInsurance();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getInsurances";
	}
	
	@GetMapping("/getInsurances")
	public String getAllInsurance(Model model) {
		List<Insurance> insurances = insuranceService.getAllInsurance();
		model.addAttribute("insurances", insurances);
		return "list-insurance";
	}
	
	
	//For Search
	@GetMapping("/searchForm")
	public String SearchDetailsForm(Model model) {
		Search search = new Search();
		model.addAttribute("search", search);
		return "add-search";
	}
	
	@PostMapping("/saveSearch")
	public String saveSearch(@Valid Search search, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			searchService.saveSearch(search);
			List<Search> searches = searchService.getAllSearch();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getSearches";
	}
	
	@GetMapping("/getSearches")
	public String getAllSearch(Model model) {
		List<Search> searches = searchService.getAllSearch();
		model.addAttribute("searches", searches);
		return "list-search";
	}
	
	/*------------------------------------For Edit And Delete Operation-----------------------------------*/
	
	//Edit Customer
	@GetMapping("/customers/editCust/{id}")
	public String editCustomerById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editCustomerById" + id);
		if (id.isPresent()) {
			Customer customer = customerService.getCustomerById(id.get());
			model.addAttribute("customer", customer);
		} else {
			model.addAttribute("customer", new Customer());
		}
		
		
		return "add-edit-customer";
	}
	
	
	//For Delete Customer
	@GetMapping("/customers/deleteCust/{id}")
	public String deleteCustomer(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("deleteCustomer" + id);
		
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
	
	
	//Edit Vehicle
		@GetMapping("/vehicles/editVehicle/{id}")
		public String editVehicleById(Model model, @PathVariable("id") Optional<Long> id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("editVehicleById" + id);
			if (id.isPresent()) {
				Vehicle vehicle = vehicleService.getVehicleById(id.get());
				model.addAttribute("vehicle", vehicle);
			} else {
				model.addAttribute("vehicle", new Vehicle());
			}
			
			
			return "add-edit-vehicle";
		}
		
		
		//For Delete Vehicle
		@GetMapping("/vehicles/deleteVehicle/{id}")
		public String deleteVehicle(Model model, @PathVariable("id") Long id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("deleteVehicle" + id);
			
			vehicleService.deleteVehicle(id);
			return "redirect:/";
		}
		
		
		//Edit Insurance
		@GetMapping("/insurances/editInsurance/{id}")
		public String editInsuranceById(Model model, @PathVariable("id") Optional<Long> id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("editInsuranceById" + id);
			if (id.isPresent()) {
				Insurance insurance = insuranceService.getInsuranceById(id.get());
				model.addAttribute("insurance", insurance);
			} else {
				model.addAttribute("insurance", new Insurance());
			}
			
			
			return "add-edit-insurance";
		}
		
		
		//For Delete Insurance
		@GetMapping("/insurances/deleteInsurance/{id}")
		public String deleteInsurance(Model model, @PathVariable("id") Long id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("deleteInsurance" + id);
			
			insuranceService.deleteInsurance(id);
			return "redirect:/";
		}
		
		//Edit Search
		@GetMapping("/searches/editSearch/{id}")
		public String editSearchrById(Model model, @PathVariable("id") Optional<Long> id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("editSearchById" + id);
			if (id.isPresent()) {
				Search search = searchService.getSearchById(id.get());
				model.addAttribute("search", search);
			} else {
				model.addAttribute("search", new Search());
			}
			
			
			return "add-edit-search";
		}
		
		
		//For Delete Insurance
		@GetMapping("/searches/deletesearch/{id}")
		public String deleteSearch(Model model, @PathVariable("id") Long id) 
								throws RecordNotFoundException 
		{
			
			System.out.println("deleteSearch" + id);
			
			searchService.deleteSearch(id);
			return "redirect:/";
		}
	
	
	
	
}