package com.lv.smartstock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lv.smartstock.services.DBService;
import com.lv.smartstock.services.EmailService;
import com.lv.smartstock.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
