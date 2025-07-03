package com.example.assetmanagement;


import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.ReturnRequest;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.ReturnRequestRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReturnRequestRepoTest {

    @Autowired
    private ReturnRequestRepo returnRequestRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Test
    public void testCreateReturnRequest() {
        Long employeeId = 1L;
        Long assetId = 1L; // change to allocated asset ID

        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        Asset asset = assetRepo.findById(assetId).orElseThrow();

        ReturnRequest request = new ReturnRequest();
        request.setEmployee(employee);
        request.setAsset(asset);
        request.setReason("Returning after testing");
        request.setStatus(RequestStatus.PENDING); // or directly APPROVED, depending on business logic
        request.setRequestDate(LocalDate.now());

        ReturnRequest saved = returnRequestRepo.save(request);

        assertNotNull(saved.getId());
        assertEquals(RequestStatus.PENDING, saved.getStatus());
    }
    @Test
    public void testUpdateReturnRequestStatus() {
        Long requestId = 1L;
        
        // 1. Fetch the return request
        ReturnRequest returnRequest = returnRequestRepo.findById(requestId)
            .orElseThrow();

        // 2. Change status to APPROVED
        returnRequest.setStatus(RequestStatus.APPROVED);

        // 3. Save updated request
        returnRequestRepo.save(returnRequest);

        // 4. Assertions
        ReturnRequest updated = returnRequestRepo.findById(requestId).orElseThrow();
        assertEquals(RequestStatus.APPROVED, updated.getStatus());
    }

}
