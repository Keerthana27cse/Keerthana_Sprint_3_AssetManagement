package com.example.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.User;
import com.example.assetmanagement.enums.UserRole;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.UserRepo;

@Service
public class UserService {

    @Autowired private UserRepo userRepo;
    @Autowired private EmployeeRepo empRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    public String register(Employee emp) {
        if (empRepo.findByEmail(emp.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email Already Registered");
        }
        if (userRepo.findByUsername(emp.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username Already Taken");
        }

        // Encrypt employee password
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
        empRepo.save(emp);

        // Create corresponding User entity
        User user = new User();
        user.setEmail(emp.getEmail());
        user.setUsername(emp.getUsername());
        user.setPassword(emp.getPassword()); // already encoded
        user.setUserrole(UserRole.EMPLOYEE);

        userRepo.save(user);
        return "Registration Successful";
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(() ->
            new IllegalArgumentException("User with ID " + id + " not found"));
    }
    public String forgotPassword(String email, String username, String newPassword) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Email not registered");
        }

        User user = userOpt.get();
        
        if (!user.getUsername().equals(username)) {
            throw new IllegalArgumentException("Username does not match with email");
        }

        // Encode and update password
        String encodedPwd = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPwd);
        userRepo.save(user);

        // Also update Employee table if exists
        Optional<Employee> empOpt = empRepo.findByEmail(email);
        empOpt.ifPresent(emp -> {
            emp.setPassword(encodedPwd);
            empRepo.save(emp);
        });

        return "Password updated successfully";
    }

}
