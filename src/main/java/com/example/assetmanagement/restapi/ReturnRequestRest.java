package com.example.assetmanagement.restapi;

import com.example.assetmanagement.dto.ReturnRequestDTO;
import com.example.assetmanagement.entity.ReturnRequest;
import com.example.assetmanagement.mapper.ReturnRequestMapper;
import com.example.assetmanagement.service.ReturnRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/return-requests")
public class ReturnRequestRest {

    @Autowired private ReturnRequestService returnRequestService;

    // ---------------- EMPLOYEE ----------------

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<?> submitReturnRequest(@RequestBody ReturnRequestDTO dto) {
        try {
            ReturnRequest saved = returnRequestService.submitRequest(dto);
            return ResponseEntity.ok(ReturnRequestMapper.toDTO(saved));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/my-requests")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<List<ReturnRequestDTO>> getMyRequests() {
        try {
            List<ReturnRequestDTO> list = returnRequestService.getRequestsByLoggedInEmployee()
                .stream().map(ReturnRequestMapper::toDTO).collect(Collectors.toList());
            return ResponseEntity.ok(list);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/mark-returned/{id}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<String> markReturned(@PathVariable Long id) {
        try {
            String msg = returnRequestService.markAsReturnedByEmployee(id);
            return ResponseEntity.ok(msg);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // ---------------- ADMIN ----------------

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ReturnRequestDTO>> getAllRequests() {
        List<ReturnRequestDTO> list = returnRequestService.getAllRequests()
            .stream().map(ReturnRequestMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> approveRequest(@PathVariable Long id) {
        String msg = returnRequestService.approveReturnRequest(id);
        if (msg.contains("not found") || msg.contains("already processed"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/confirm-return/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> confirmReturn(@PathVariable Long id) {
        String msg = returnRequestService.finalizeReturnByAdmin(id);
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/reject/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> rejectRequest(@PathVariable Long id) {
        try {
            ReturnRequest rejected = returnRequestService.rejectRequest(id);
            return ResponseEntity.ok(ReturnRequestMapper.toDTO(rejected));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
