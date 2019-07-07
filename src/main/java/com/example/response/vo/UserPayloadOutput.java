package com.example.response.vo;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserPayloadOutput {

	Long id;

	String email;

	private String name;

	private String Password;

	@Column(name = "CREATED_DATE")
	Date date;

	
}
