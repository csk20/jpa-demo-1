package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ActivityTypeEntity;


public interface ActivityTypeRepository extends JpaRepository<ActivityTypeEntity,String>{
	
	

}
