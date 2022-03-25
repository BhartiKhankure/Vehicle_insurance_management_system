package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.Customer;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.CustomerRepository;
import com.edu.VehicleManagementAppSpringBoot.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> insertAll(List<Customer> customer) {
		return (List<Customer>) customerRepository.saveAll(customer);

	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();

		} else {
			throw new ResourceNotFound("Customer", "Id", id);
		}

	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		return customerRepository.findCustomerByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameOrEmail(String firstName, String email) {
		return customerRepository.findByFirstNameOrEmail(firstName, email);
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer cust = new Customer();
		try {
			cust = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
		cust.setContactNumber(customer.getContactNumber());
		cust.setGender(customer.getGender());
		cust.setDateOfBirth(customer.getDateOfBirth());
		cust.setNationality(customer.getNationality());
		cust.setLicenceNumber(customer.getLicenceNumber());

		customerRepository.save(cust);
		return cust;
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "Id", id));
		customerRepository.deleteById(id);

	}

	@Override
	public Customer updateCustomerPartially(Customer customer, long id) {
		Customer newCust = new Customer();
		try {
			newCust = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (customer.getFirstName() != null) {
			newCust.setFirstName(customer.getFirstName());
		}
		if (customer.getLastName() != null) {
			newCust.setLastName(customer.getLastName());
		}
		if (customer.getEmail() != null) {
			newCust.setEmail(customer.getEmail());
		}
		if (customer.getContactNumber() != null) {
			newCust.setContactNumber(customer.getContactNumber());
		}
		if(customer.getDateOfBirth() != null) {
			newCust.setDateOfBirth(customer.getDateOfBirth());
		}
		if(customer.getGender() != null) {
			newCust.setGender(customer.getGender());
		}
		if(customer.getNationality() != null) {
			newCust.setNationality(customer.getNationality());
		}
		if(customer.getLicenceNumber() != null) {
			newCust.setLicenceNumber(customer.getLicenceNumber());
		}

		customerRepository.save(newCust);
		return newCust;
	}

	@Override
	public List<Customer> getCustomerInOrderDesc() {
		return customerRepository.findCustomerInOrderDesc();
	}

	@Override
	public Customer getCustomerFullNameById(long id) {
		return customerRepository.findCustomerFullNameById(id);
	}

	@Override
	public Customer getCustomerNationalityEmailGenderById(long id) {
		return customerRepository.findCustomerNationalityEmailGenderById(id);
	}

	

	
//	@Override
//	public List<User> getUserByVehicleGroup() {
//		return userRepository.findUserByVehicleGroup();
//	}

}

