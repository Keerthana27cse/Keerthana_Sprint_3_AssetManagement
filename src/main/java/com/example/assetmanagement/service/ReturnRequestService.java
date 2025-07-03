package com.example.assetmanagement.service;

import com.example.assetmanagement.dto.ReturnRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.ReturnRequest;
import com.example.assetmanagement.enums.AllocationStatus;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.ReturnRequestRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReturnRequestService {

    @Autowired private ReturnRequestRepo returnRequestRepo;
    @Autowired private AssetAllocationRepo assetAllocationRepo;
    @Autowired private EmployeeRepo employeeRepo;
    @Autowired private AssetRepo assetRepo;

    // ------------------- EMPLOYEE -------------------

    public ReturnRequest submitRequest(ReturnRequestDTO dto) {
        String email = getLoggedInUserEmail();
        if (email == null) throw new IllegalStateException("Unauthorized: no logged-in user");

        Employee employee = employeeRepo.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with email: " + email));

        Asset asset = assetRepo.findById(dto.getAssetId())
            .orElseThrow(() -> new IllegalArgumentException("Asset not found with ID: " + dto.getAssetId()));

        ReturnRequest request = new ReturnRequest();
        request.setEmployee(employee);
        request.setAsset(asset);
        request.setReason(dto.getReason());
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(LocalDateTime.now());

        return returnRequestRepo.save(request);
    }

    public List<ReturnRequest> getRequestsByLoggedInEmployee() {
        String email = getLoggedInUserEmail();
        if (email == null) throw new IllegalStateException("Unauthorized");

        Employee emp = employeeRepo.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return returnRequestRepo.findByEmployeeId(emp.getId());
    }

    public String markAsReturnedByEmployee(Long requestId) {
        ReturnRequest req = returnRequestRepo.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found"));

        if (req.getStatus() != RequestStatus.APPROVED) {
            return "Only approved requests can be marked returned by employee.";
        }

        req.setStatus(RequestStatus.MARKED_RETURNED);
        returnRequestRepo.save(req);
        return "Asset marked as returned by employee.";
    }

    // ------------------- ADMIN -------------------

    public List<ReturnRequest> getAllRequests() {
        return returnRequestRepo.findAll();
    }

    public String approveReturnRequest(Long returnRequestId) {
        ReturnRequest returnRequest = returnRequestRepo.findById(returnRequestId)
            .orElseThrow(() -> new IllegalArgumentException("Return request not found"));

        if (returnRequest.getStatus() != RequestStatus.PENDING) {
            return "Request already processed.";
        }

        returnRequest.setStatus(RequestStatus.APPROVED);
        returnRequestRepo.save(returnRequest);
        return "Return request approved.";
    }

    public String finalizeReturnByAdmin(Long requestId) {
        ReturnRequest req = returnRequestRepo.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Return request not found"));

        if (req.getStatus() != RequestStatus.MARKED_RETURNED) {
            return "Request not ready for final confirmation.";
        }

        req.setStatus(RequestStatus.RETURNED);
        req.setReturnDate(LocalDateTime.now());

        AssetAllocation allocation = assetAllocationRepo.findByAssetAndEmployeeAndAllocationStatus(
            req.getAsset(), req.getEmployee(), AllocationStatus.ALLOCATED);

        if (allocation != null) {
            allocation.setReturnDate(LocalDate.now());
            allocation.setAllocationStatus(AllocationStatus.RETURNED);
            assetAllocationRepo.save(allocation);
        }

        returnRequestRepo.save(req);
        return "Return confirmed by admin.";
    }

    public ReturnRequest rejectRequest(Long requestId) {
        ReturnRequest request = returnRequestRepo.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Return request not found"));

        request.setStatus(RequestStatus.REJECTED);
        return returnRequestRepo.save(request);
    }

    // ------------------- Helper -------------------

    private String getLoggedInUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
        return null;
    }
}
