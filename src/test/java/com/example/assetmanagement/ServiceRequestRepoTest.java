package com.example.assetmanagement;

import com.example.assetmanagement.entity.*;
import com.example.assetmanagement.enums.IssueType;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceRequestRepoTest {

    @Autowired
    private ServiceRequestRepo serviceRequestRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Test
    public void testCreateServiceRequest() {
        // Fetch existing employee and asset (assumed to exist in DB)
        Long employeeId = 1L;
        Long assetId = 1L;

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        // Create service request
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setEmployee(employee);
        serviceRequest.setAsset(asset);
        serviceRequest.setIssueType(IssueType.SOFTWARE); // or HARDWARE based on your enum
        serviceRequest.setDescription("System freezing frequently");
        serviceRequest.setStatus(RequestStatus.PENDING);
        serviceRequest.setRequestDate(LocalDate.now());

        ServiceRequest savedRequest = serviceRequestRepo.save(serviceRequest);

        // Assertions
        assertNotNull(savedRequest.getId());
        assertEquals(employeeId, savedRequest.getEmployee().getId());
        assertEquals(assetId, savedRequest.getAsset().getId());
        assertEquals(RequestStatus.PENDING, savedRequest.getStatus());
    }
}
