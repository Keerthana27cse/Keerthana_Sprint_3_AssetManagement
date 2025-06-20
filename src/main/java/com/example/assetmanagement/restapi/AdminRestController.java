package com.example.assetmanagement.restapi;

import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AdminRestController {

    @Autowired
    private EmployeeRepo emprepo;

    // Get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(emprepo.findAll());
    }

    // get
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return emprepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (!emprepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Invalid employee ID");
        }
        emprepo.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        if (!emprepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Employee not found");
        }

        updatedEmp.setId(id);
        emprepo.save(updatedEmp);
        return ResponseEntity.ok("Employee updated successfully!");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> adminDashboard() {
        return ResponseEntity.ok("Welcome to Admin Dashboard");
    }
}
/*{
  "username": "keerthana123",
  "name": "Keerthana",
  "email": "keerthana@example.com",
  "contactNumber": "9876543210",
  "address": "Chennai",
  "password": "password123",
  "gender": "FEMALE",
  "role": "EMPLOYEE"
}
*/
