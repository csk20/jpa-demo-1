package com.example.service;

import org.springframework.stereotype.Service;

import com.example.request.vo.UserRegistrationInput;
import com.example.resource.UserRegistrationResource;
import com.example.response.vo.UserRegistrationOutput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserRegistrationService {
	

	
	public UserRegistrationOutput registration( UserRegistrationInput input) {
		String method="registration()";
		log.info("start of the method [{}] and method [{}]",method,1);
		UserRegistrationOutput userRegistrationOutput= new UserRegistrationOutput();
		userRegistrationOutput.setFirstName("Chandan");
		userRegistrationOutput.setLastNname("Kushwaha");
		userRegistrationOutput.setMiddleName("Singh");
		userRegistrationOutput.setPassword("12345");
		
		return userRegistrationOutput;
	}
	
	
	

}
