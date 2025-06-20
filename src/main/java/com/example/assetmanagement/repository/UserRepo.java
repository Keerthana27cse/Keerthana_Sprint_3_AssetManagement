package com.example.assetmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.User;

public interface UserRepo extends JpaRepository<User, Long> 
{
	 User  findByEmail(String email);  // to search by email
	 // to search by email

	Optional<User> findByUsername(String username);

	//testing

}

