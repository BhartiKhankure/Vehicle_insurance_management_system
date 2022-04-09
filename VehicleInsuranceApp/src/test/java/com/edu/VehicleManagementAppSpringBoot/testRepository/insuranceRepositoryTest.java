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

import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;
import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.repository.InsuranceRepository;
import com.edu.VehicleManagementAppSpringBoot.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class insuranceRepositoryTest {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Test
	@Rollback(false)

    public void saveInsuranceTest() {
    	Insurance insurance = insuranceRepository.save(new Insurance("Policy Bazar","12345","12/12/2024"));
    	
    		Assertions.assertThat(insurance.getId()).isGreaterThan(0);
    	
    }
	
	@Test
	public void getInsuarnceTest() {
		Insurance insurance = insuranceRepository.findById(9L).get();
		Assertions.assertThat(insurance.getId()).isEqualTo(9L);

	}
	
	@Test
	public void getInsuranceListTest() {
		List<Insurance> insurances = insuranceRepository.findAll();
		Assertions.assertThat(insurances.size()).isGreaterThan(0);

	}
	
	@Test
	public void updateInsuranceTest() {
		Insurance insurance = insuranceRepository.findById(9L).get();
		insurance.setInsuranceNumber("12345");
		Insurance updated = insuranceRepository.save(insurance); 
		Assertions.assertThat(insurance.getInsuranceNumber()).isEqualTo("12345");

		
	}
	
	@Test
	public void deleteUserTest() {
		Insurance ins = insuranceRepository.findById(9L).get();
		insuranceRepository.delete(ins);
		Insurance insurance=null;
		Optional<Insurance> ins1 = insuranceRepository.findByInsuranceNumber("12345");
		if(ins1.isPresent()) {
			insurance = ins1.get();
		}
		
		Assertions.assertThat(insurance).isNull();
		
	}
}

