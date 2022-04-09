package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.UserRepository;
import com.edu.VehicleManagementAppSpringBoot.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> insertAll(List<User> user) {
		return (List<User>) userRepository.saveAll(user);

	} 

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();

		} else {
			throw new ResourceNotFound("User", "Id", id);
		}

	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.findUserByFirstName(firstName);
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	public List<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<User> getUserByFirstNameOrLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public List<User> getUserByFirstNameOrEmail(String firstName, String email) {
		return userRepository.findByFirstNameOrEmail(firstName, email);
	}

	@Override
	public User updateUser(User user, long id) {
		User us = new User();
	try {
		us = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}
	us.setFirstName(user.getFirstName());
	us.setLastName(user.getLastName());
	us.setEmail(user.getEmail());
	us.setContactNumber(user.getContactNumber());
	us.setGender(user.getGender());
	us.setDateOfBirth(user.getDateOfBirth());
	us.setNationality(user.getNationality());
	us.setLicenceNumber(user.getLicenceNumber());

	userRepository.save(us);
		return us;
	}
	
	 

	@Override
	public void deleteUser(long id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "Id", id));
		userRepository.deleteById(id);

	}

	@Override
	public User updateUserPartially(User user, long id) {
		User newUser = new User();
		try {
			newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (user.getFirstName() != null) {
			newUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			newUser.setLastName(user.getLastName());
		}
		if (user.getEmail() != null) {
			newUser.setEmail(user.getEmail());
		}
		if (user.getContactNumber() != null) {
			newUser.setContactNumber(user.getContactNumber());
		}
		if(user.getDateOfBirth() != null) {
			newUser.setDateOfBirth(user.getDateOfBirth());
		}
		if(user.getGender() != null) {
			newUser.setGender(user.getGender());
		}
		if(user.getNationality() != null) {
			newUser.setNationality(user.getNationality());
		}
		if(user.getLicenceNumber() != null) {
			newUser.setLicenceNumber(user.getLicenceNumber());
		}

		userRepository.save(newUser);
		return newUser;
	}

	@Override
	public List<User> getUserInOrderDesc() {
		return userRepository.findUserInOrderDesc();
	}

	@Override
	public User getUserFullNameById(long id) {
		return userRepository.findUserFullNameById(id);
	}

	



	@Override
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public long getIdByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	



}

