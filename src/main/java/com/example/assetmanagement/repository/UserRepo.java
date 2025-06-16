package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.User;

public interface UserRepo extends JpaRepository<User, Long> 
{
	User findByEmail(String email);  // to search by email

}

