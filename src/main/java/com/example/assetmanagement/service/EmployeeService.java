// EmployeeService.java
package com.example.assetmanagement.service;

import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.User;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.UserRepo;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;
    @Autowired private UserRepo userRepo;


    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + id));
    }
    @Transactional
    public String deleteEmployee(Long id) {
        Optional<Employee> empOpt = empRepo.findById(id);

        if (empOpt.isEmpty()) {
            throw new IllegalArgumentException("Employee not found with ID: " + id);
        }

        Employee emp = empOpt.get();

        // First delete user by email
        Optional<User> userOpt = userRepo.findByEmail(emp.getEmail());
        userOpt.ifPresent(userRepo::delete);

        // Then delete employee
        empRepo.delete(emp);

        return "Employee and corresponding user deleted successfully";
    }

    public String updateEmployee(Employee updateEmp) {
        if (updateEmp.getId() == null) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        Employee existingEmp = empRepo.findById(updateEmp.getId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found."));

        updateEmp.setPassword(existingEmp.getPassword()); // Preserve password
        empRepo.save(updateEmp);
        return "Employee updated successfully!";
    }
    public Employee getByEmail(String email) {
        return empRepo.findByEmail(email).orElse(null);
    }

}