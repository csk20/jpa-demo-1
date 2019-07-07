package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.IssuerDetailsEntity;
import com.example.entity.IssuerProfileEntity;


public interface IssuerProfileRepository extends JpaRepository<IssuerProfileEntity,String>{
	
	

}
