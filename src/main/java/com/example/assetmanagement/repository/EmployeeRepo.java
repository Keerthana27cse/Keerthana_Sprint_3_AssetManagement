package com.example.assetmanagement.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	boolean existsByUsername(String username);

	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByUsername(String username);
	


}
