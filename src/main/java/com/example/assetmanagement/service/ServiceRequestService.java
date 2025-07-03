package com.example.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.assetmanagement.dto.ServiceRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.ServiceRequest;
import com.example.assetmanagement.enums.AllocationStatus;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.ServiceRequestRepo;
@Service
public class ServiceRequestService {

    @Autowired private AssetRepo assetRepo;
    @Autowired private ServiceRequestRepo serviceRequestRepo;
    @Autowired private EmployeeRepo employeeRepo;
    @Autowired private AssetAllocationRepo allocationRepo;

    // Utility to get logged-in email
    private String getLoggedInUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
        return null;
    }

    // EMPLOYEE: Submit request (auth inside service)
    public String submitServiceRequest(ServiceRequestDTO dto) {
        String email = getLoggedInUserEmail();
        if (email == null) return "Unauthorized: No logged-in user";

        Employee emp = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        Asset asset = assetRepo.findById(dto.getAssetId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid asset ID"));

        // ✅ Get all allocations for this asset with status ALLOCATED
        List<AssetAllocation> allocations = allocationRepo
                .findByAssetAndAllocationStatus(asset, AllocationStatus.ALLOCATED);

        // ✅ Check if *any* allocation is for the current employee
        boolean isAllocatedToEmployee = allocations.stream()
                .anyMatch(a -> a.getEmployee().getId().equals(emp.getId()));

        if (!isAllocatedToEmployee) {
            return "You can only raise service requests for assets currently allocated to you.";
        }

        // ✅ Create the service request
        ServiceRequest request = new ServiceRequest();
        request.setAsset(asset);
        request.setEmployee(emp);
        request.setIssueType(dto.getIssueType());
        request.setDescription(dto.getDescription());
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(LocalDateTime.now());

        serviceRequestRepo.save(request);
        return "Service request submitted successfully.";
    }



    public List<ServiceRequest> getRequestsByLoggedInEmployee() {
        String email = getLoggedInUserEmail();
        if (email == null) {
            throw new RuntimeException("Unauthorized access");
        }

        Employee emp = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return serviceRequestRepo.findByEmployeeId(emp.getId());
    }

    // ADMIN
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestRepo.findAll();
    }

    public ServiceRequest approveServiceRequest(Long requestId) {
        ServiceRequest request = serviceRequestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Service request not found"));
        request.setStatus(RequestStatus.APPROVED);
        return serviceRequestRepo.save(request);
    }

    public ServiceRequest rejectServiceRequest(Long requestId) {
        ServiceRequest request = serviceRequestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Service request not found"));
        request.setStatus(RequestStatus.REJECTED);
        return serviceRequestRepo.save(request);
    }

    public ServiceRequest updateRequestStatus(Long requestId, RequestStatus status) {
        ServiceRequest request = serviceRequestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Service request not found"));
        request.setStatus(status);
        return serviceRequestRepo.save(request);
    }
}
