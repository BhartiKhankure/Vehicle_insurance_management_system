package com.edu.VehicleManagementAppSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
	}
	
	
	
  	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()

		.authorizeRequests()
		.antMatchers("/vehicleForm").hasAuthority("ROLE_USER")
		.antMatchers("/insuranceForm").hasAuthority("ROLE_ADMIN")
		.antMatchers("/","/registration").permitAll()// index.html
		//.antMatchers("/**").authenticated()

		.and().httpBasic()
		
		.and().formLogin()
		.defaultSuccessUrl("/user/userAccount",true)
	
		 .permitAll()
		.and().logout()
		.logoutSuccessUrl("/")
		.permitAll()
		
		;

	}
	
  
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
