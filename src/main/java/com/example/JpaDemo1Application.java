package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication

public class JpaDemo1Application {
	


	public static void main(String[] args) {
		SpringApplication.run(JpaDemo1Application.class, args);
	//log.info(System.getenv("spring.profile.active"));
		
	
		
		
	}

}
