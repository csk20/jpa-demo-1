package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserTable;


public interface UserRepository extends JpaRepository<UserTable ,Long> {

	//List<User> findByEmail(String email);

  //  List<User> findByDate(Date date);

	// custom query example and return a stream
 //   @Query("select c from Customer c where c.email = :email")
  //  Stream<User> findByEmailReturnStream(@Param("email") String email);
	
}
