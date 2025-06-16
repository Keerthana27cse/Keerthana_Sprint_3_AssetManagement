package com.example.assetmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Employee findByEmail(String email);
}
