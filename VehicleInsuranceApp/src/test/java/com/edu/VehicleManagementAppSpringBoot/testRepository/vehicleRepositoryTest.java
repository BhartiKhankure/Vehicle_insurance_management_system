package com.edu.VehicleManagementAppSpringBoot.testRepository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.VehicleManagementAppSpringBoot.entity.Vehicle;
import com.edu.VehicleManagementAppSpringBoot.repository.VehicleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class vehicleRepositoryTest {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Test
	@Rollback(false)

    public void saveVehicleTest() {
    	Vehicle vehicle = vehicleRepository.save(new Vehicle("Two Wheeler","MH-1234","Tata Motors","Honda"));
    	
    		Assertions.assertThat(vehicle.getId()).isGreaterThan(0);
    	
    }
	
	@Test
	public void getVehicleTest() {
		Vehicle vehicle = vehicleRepository.findById(9L).get();
		Assertions.assertThat(vehicle.getId()).isEqualTo(9L);

	}
	
	@Test
	public void getVehicleListTest() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		Assertions.assertThat(vehicles.size()).isGreaterThan(0);

	}
	
	@Test
	public void updateVehicleTest() {
		Vehicle Vehicle = vehicleRepository.findById(9L).get();
		Vehicle.setCategory("Two Wheeler");
		Vehicle updated = vehicleRepository.save(Vehicle); 
		Assertions.assertThat(Vehicle.getCategory()).isEqualTo("Two Wheeler");

		
	}
	
	@Test
	public void deleteVehicleTest() {
		Vehicle veh = vehicleRepository.findById(9L).get();
		vehicleRepository.delete(veh);
		Vehicle vehicle=null;
		Optional<Vehicle> veh1 = vehicleRepository.findByCategory("Two Wheeler");
		if(veh1.isPresent()) {
			vehicle = veh1.get();
		}
		
		Assertions.assertThat(vehicle).isNull();
		
	}
}

