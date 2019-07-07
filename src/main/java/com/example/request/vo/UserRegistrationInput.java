package com.example.request.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRegistrationInput {
	
	

	private String firstName;
	
	private String lastNname;
	
	private String email;
	
	private String phoneNumber;

	private String password;

	private String gender;

	

}
