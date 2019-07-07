package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class UserTable {
	
	@Id
	
	@GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	//@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "USER_SEQ")
	Long id;

	String email;

	private String name;

	private String Password;

	@Column(name = "CREATED_DATE")
	Date date;




}
