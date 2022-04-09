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

import com.edu.VehicleManagementAppSpringBoot.entity.User;
import com.edu.VehicleManagementAppSpringBoot.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class userRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Rollback(false)

    public void saveUserTest() {
    	User user = userRepository.save(new User("john","deo","john@gmail.com","9898989898"));
    	
    		Assertions.assertThat(user.getId()).isGreaterThan(0);
    	
    }
	
	@Test
	public void getUserTest() {
		User user = userRepository.findById(9L).get();
		Assertions.assertThat(user.getId()).isEqualTo(9L);

	}
	
	@Test
	public void getUserListTest() {
		List<User> users = userRepository.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);

	}
	
	@Test
	public void updateUserTest() {
		User user = userRepository.findById(9L).get();
		user.setEmail("deo@gmail.com");
		User updated = userRepository.save(user); 
		Assertions.assertThat(user.getEmail()).isEqualTo("deo@gmail.com");

		
	}
	
	@Test
	public void deleteUserTest() {
		User us = userRepository.findById(9L).get();
		userRepository.delete(us);
		User user=null;
		Optional<User> us1 = userRepository.findByEmail("deo@gmail.com");
		if(us1.isPresent()) {
			user = us1.get();
		}
		
		Assertions.assertThat(user).isNull();
		
	}
}

