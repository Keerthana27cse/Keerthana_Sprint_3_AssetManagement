package com.example.assetmanagement.restapi;

import com.example.assetmanagement.dto.AuthResponse;
import com.example.assetmanagement.dto.LoginRequest;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.security.JwtUtil;
import com.example.assetmanagement.service.UserService;
import com.example.assetmanagement.service.CustomUserDetailsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/auth")
public class UserRest {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private CustomUserDetailsService userDetailsService;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserService userService;

    // ----------------------- Register EMPLOYEE -----------------------
    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody Employee emp, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            String msg = userService.register(emp);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // ----------------------- Login (Employee/Admin) -----------------------
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            // This triggers the CustomUserDetailsService and checks status
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

            String token = jwtUtil.generateToken(userDetails);
            String role = userDetails.getAuthorities().stream()
                    .findFirst().map(auth -> auth.getAuthority().replace("ROLE_", ""))
                    .orElse("EMPLOYEE");

            return ResponseEntity.ok(new AuthResponse(token, loginRequest.getEmail(), role));

        } catch (RuntimeException e) {
            if (e.getMessage().toLowerCase().contains("inactive")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account inactive. Please contact your manager.");
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // ----------------------- Forgot Password (Mockup) -----------------------
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String newPassword) {

        try {
            String msg = userService.forgotPassword(email, username, newPassword);
            return ResponseEntity.ok(msg);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
