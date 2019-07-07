package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TokenTypeEntity;


public interface TokenTypeRepository extends JpaRepository<TokenTypeEntity,String>{
	
	

}
