package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.UserAddress;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.UserAddressRepository;
import com.edu.VehicleManagementAppSpringBoot.service.UserAddressService;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	private UserAddressRepository userAddressRepository;

	public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
		super();
		this.userAddressRepository = userAddressRepository;
	}

	@Override
	public UserAddress saveUserAddress(UserAddress userAddress) {
		return userAddressRepository.save(userAddress);
	}

	@Override
	public List<UserAddress> getAllUserAddress() {
		return userAddressRepository.findAll();
	}

	@Override
	public UserAddress getUserAddressById(long id) {
		Optional<UserAddress> userAddr = userAddressRepository.findById(id);
		if (userAddr.isPresent()) {
			return userAddr.get();
		} else {
			throw new ResourceNotFound("Vehicle", "id", id);
		}
	}

	@Override
	public UserAddress updateUserAddress(UserAddress userAddress, long id) {
		UserAddress userAddr = new UserAddress();
		try {
			userAddr = userAddressRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFound("UserAddress", "id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		userAddr.setPlotNumber(userAddress.getPlotNumber());
		userAddr.setNearBy(userAddress.getNearBy());
		userAddr.setArea(userAddress.getArea());
		userAddr.setCity(userAddress.getCity());
		userAddr.setState(userAddress.getState());
		userAddr.setZipCode(userAddress.getZipCode());

		return userAddr;
	}

	@Override
	public void deleteUserAddress(long id) {
		userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFound("UserAddress", "id", id));
		userAddressRepository.deleteById(id);

	}

	@Override
	public UserAddress updateUserAddressPartially(UserAddress userAddress, long id) {
		UserAddress newAddr = new UserAddress();
		try {
			newAddr = userAddressRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFound("UserAddress", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (userAddress.getPlotNumber() != null) {
			newAddr.setPlotNumber(userAddress.getPlotNumber());
		}
		if (userAddress.getNearBy() != null) {
			newAddr.setNearBy(userAddress.getNearBy());
		}
		if (userAddress.getArea() != null) {
			newAddr.setArea(userAddress.getArea());
		}
		if (userAddress.getCity() != null) {
			newAddr.setCity(userAddress.getCity());
		}
		if (userAddress.getState() != null) {
			newAddr.setState(userAddress.getState());
		}
		if (userAddress.getZipCode() != null) {
			newAddr.setZipCode(userAddress.getZipCode());
		}
		if (userAddress.getUser() != null) {
			newAddr.setUser(userAddress.getUser());
		}
		userAddressRepository.save(newAddr);
		return newAddr;
	}

	@Override
	public List<UserAddress> insertAll(List<UserAddress> userAddress) {
		return (List<UserAddress>) userAddressRepository.saveAll(userAddress);

	}

	@Override
	public List<UserAddress> getUserAddressByPlotNumber(String plotNumber) {
		return userAddressRepository.findByPlotNumber(plotNumber);
	}

	@Override
	public List<UserAddress> getUserAddressByArea(String area) {
		return userAddressRepository.findByArea(area);
	}

	@Override
	public List<UserAddress> getUserAddressByCity(String city) {
		return userAddressRepository.findByCity(city);
	}

}
