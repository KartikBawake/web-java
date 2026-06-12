package com.AppConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Entity.Users;

@Configuration
public class Config {

	@Bean
	public Users objUser(
			@Value("Kartik") String name,
			@Value("Kartik@Bawake") String email,
			@Value("Kartik123") String password
			) {
		return new Users(name, email, password);
	}
	
}
