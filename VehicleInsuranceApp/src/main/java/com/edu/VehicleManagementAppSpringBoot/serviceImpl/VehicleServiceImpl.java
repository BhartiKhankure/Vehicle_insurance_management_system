package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.VehicleRepository;
import com.edu.VehicleManagementAppSpringBoot.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleRepository vehicleRepository;

	public VehicleServiceImpl(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (vehicle.isPresent()) {
			return vehicle.get();
		} else {
			throw new ResourceNotFound("Vehicle", "id", id);
		}
	}

	@Override
	public List<Vehicle> getVehicleByManufacturer(String manufacturer) {
		return vehicleRepository.findByManufacturer(manufacturer);
	}

	@Override
	public List<Vehicle> getVehicleByPendingFines(double pendingFines) {
		return vehicleRepository.findByPendingFines(pendingFines);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, long id) {
		Vehicle veh = new Vehicle();
		try {
			veh = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Vehicle", "id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		veh.setCategory(vehicle.getCategory());
		veh.setPlateNumber(vehicle.getPlateNumber());
		veh.setManufacturer(vehicle.getManufacturer());
		veh.setType(vehicle.getType());
		veh.setRegistrationDate(vehicle.getRegistrationDate());
		veh.setPendingFines(vehicle.getPendingFines());

		vehicleRepository.save(veh);
		return veh;
	}

	@Override
	public void deleteVehicle(long id) {
		vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Vehicle", "id", id));
		vehicleRepository.deleteById(id);

	}

	@Override
	public List<Vehicle> insertAll(List<Vehicle> vehicle) {
		return (List<Vehicle>) vehicleRepository.saveAll(vehicle);

	}

	@Override
	public Vehicle updateVehiclePartially(Vehicle vehicle, long id) {
		Vehicle newVehicle = new Vehicle();
		try {
			newVehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Vehicle", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (vehicle.getCategory() != null) {
			newVehicle.setCategory(vehicle.getCategory());
		}
		if (vehicle.getPlateNumber() != null) {
			newVehicle.setPlateNumber(vehicle.getPlateNumber());
		}
		if (vehicle.getManufacturer() != null) {
			newVehicle.setManufacturer(vehicle.getManufacturer());
		}
		if (vehicle.getType() != null) {
			newVehicle.setType(vehicle.getType());
		}
		
		if (vehicle.getRegistrationDate() != null) {
			newVehicle.setRegistrationDate(vehicle.getRegistrationDate());
		}
		if(vehicle.getPendingFines() != 0) {
			newVehicle.setPendingFines(vehicle.getPendingFines());
		}
		if (vehicle.getInsurance() != null) {
			newVehicle.setInsurance(vehicle.getInsurance());
		}
		vehicleRepository.save(newVehicle);
		return newVehicle;
	}

	@Override
	public Optional<Vehicle> getVehicleByCategory(String category) {
		return vehicleRepository.findByCategory(category);
	}

	@Override
	public List<Vehicle> getVehicleByType(String type) {
		return vehicleRepository.findByType(type);
	}

	@Override
	public List<Vehicle> getVehiclesByUserId(long id) {
		return vehicleRepository.findVehiclesByUserId(id);
	}

	@Override
	public List<Vehicle> getVehiclesByUserId(User id) {
		// TODO Auto-generated method stub
		return null;
	}


}
