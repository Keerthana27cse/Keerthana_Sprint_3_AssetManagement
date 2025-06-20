package com.example.assetmanagement.restapi;

import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.User;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee emp) {
        if (employeeRepo.findByEmail(emp.getEmail()) != null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
        }

        employeeRepo.save(emp);
       
        User user = new User();
        user.setUsername(emp.getUsername());
        user.setEmail(emp.getEmail());
        user.setPassword(emp.getPassword());
        user.setUserrole(emp.getRole());
        userRepo.save(user);

        return ResponseEntity.ok(Map.of("message", "Registration successful"));
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser, HttpSession session) {
        User user = userRepo.findByEmail(loginUser.getEmail());

        if (user == null ||
            !user.getPassword().equals(loginUser.getPassword()) ||
            !user.getUsername().equals(loginUser.getUsername()) ||
            user.getUserrole() != loginUser.getUserrole()) {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid credentials"));
        }

        session.setAttribute("loggedInUser", user);

        return ResponseEntity.ok(Map.of(
            "message", "Login successful",
            "role", user.getUserrole().toString()
        ));
    }

    // Logout user
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of("message", "Logout successful"));
    }
}
