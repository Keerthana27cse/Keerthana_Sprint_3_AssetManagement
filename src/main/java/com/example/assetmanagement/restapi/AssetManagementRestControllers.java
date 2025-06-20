package com.example.assetmanagement.restapi;

import com.example.assetmanagement.model.*;
import com.example.assetmanagement.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class AssetManagementRestControllers {}

/*    @Autowired private UserRepo userRepo;
    @Autowired private EmployeeRepo employeeRepo;
    @Autowired private AssetRepo assetRepo;
    @Autowired private AssetCategoryRepo categoryRepo;
    @Autowired private NewAssetRequestRepo newAssetRequestRepo;
    @Autowired private ServiceRequestRepo serviceRequestRepo;

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
        user.setRole(emp.getRole());
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
            user.getRole() != loginUser.getRole()) {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid credentials"));
        }

        session.setAttribute("loggedInUser", user);

        return ResponseEntity.ok(Map.of(
            "message", "Login successful",
            "role", user.getRole().toString()
        ));
    }

    // User Logout
    @GetMapping("/user/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of("message", "Logout successful"));
    }

   
    // ADMIN: Add new asset
    @PostMapping("/admin/assets")
    public ResponseEntity<?> addAsset(@RequestBody Asset asset) {
        assetRepo.save(asset);
        return ResponseEntity.status(201).body(Map.of("message", "Asset added"));
    }

    // ADMIN: Get all assets
    @GetMapping("/admin/assets")
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetRepo.findAll());
    }

    // ADMIN: Update asset
    @PutMapping("/admin/assets/{id}")
    public ResponseEntity<?> updateAsset(@PathVariable Long id, @RequestBody Asset updated) {
        return assetRepo.findById(id).map(asset -> {
            asset.setAssetNo(updated.getAssetNo());
            asset.setAssetName(updated.getAssetName());
            asset.setAssetModel(updated.getAssetModel());
            asset.setManufacturingDate(updated.getManufacturingDate());
            asset.setExpiryDate(updated.getExpiryDate());
            asset.setAssetValue(updated.getAssetValue());
            asset.setAssetStatus(updated.getAssetStatus());
            asset.setCategory(updated.getCategory());
            assetRepo.save(asset);
            return ResponseEntity.ok(Map.of("message", "Asset updated"));
        }).orElse(ResponseEntity.notFound().build());
    }

    // ADMIN: Delete asset
    @DeleteMapping("/admin/assets/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable Long id) {
        if (!assetRepo.existsById(id)) return ResponseEntity.badRequest().body("Invalid asset ID");
        assetRepo.deleteById(id);
        return ResponseEntity.ok("Asset deleted");
    }

    // ADMIN: Add category
    @PostMapping("/admin/categories")
    public ResponseEntity<?> addCategory(@RequestBody AssetCategory category) {
        categoryRepo.save(category);
        return ResponseEntity.status(201).body(Map.of("message", "Category added"));
    }

    // ADMIN: Get all employees
    @GetMapping("/admin/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    // ADMIN: Delete employee
    @DeleteMapping("/admin/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepo.existsById(id)) return ResponseEntity.badRequest().body("Invalid employee ID");
        employeeRepo.deleteById(id);
        return ResponseEntity.ok("Employee deleted");
    }

    // ADMIN: Update employee
    @PutMapping("/admin/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        if (!employeeRepo.existsById(id)) return ResponseEntity.badRequest().body("Employee not found");
        emp.setId(id);
        employeeRepo.save(emp);
        return ResponseEntity.ok("Employee updated");
    }
}*/
