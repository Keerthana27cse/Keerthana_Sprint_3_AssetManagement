package com.example.assetmanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.assetmanagement.dto.NewAssetRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.AssetCategory;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.NewAssetRequest;
import com.example.assetmanagement.enums.AllocationStatus;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.NewAssetRequestRepo;
@Service
public class NewAssetRequestService {

    @Autowired private NewAssetRequestRepo requestRepo;
    @Autowired private AssetRepo assetRepo;
    @Autowired private AssetCategoryRepo categoryRepo;
    @Autowired private AssetAllocationRepo assetAllocationRepo;
    @Autowired private EmployeeRepo employeeRepo;

    public NewAssetRequest createNewAssetRequest(NewAssetRequestDTO dto) {
        // Get logged-in user's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }

        String email = authentication.getName();
        Employee employee = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("Employee not found with email: " + email));

        Long categoryId = dto.getRequestedCategoryId();
        if (categoryId == null) {
            throw new IllegalArgumentException("CategoryId must not be null");
        }
        AssetCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        Long assetId = dto.getAssetId();
        if (assetId == null) {
            throw new IllegalArgumentException("AssetId must not be null");
        }
        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found with id: " + assetId));

        NewAssetRequest request = new NewAssetRequest();
        request.setEmployee(employee);
        request.setRequestedCategory(category);
        request.setAsset(asset);
        request.setDescription(dto.getDescription());
        request.setRequestReason(dto.getRequestReason());
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(LocalDateTime.now());

        // Shipping fields
        request.setFullAddress(dto.getFullAddress());
        request.setZipCode(dto.getZipCode());
        request.setPhone(dto.getPhone());

        return requestRepo.save(request);
    }

    public List<NewAssetRequest> getRequestsByLoggedInEmployee() {
        String email = getLoggedInUserEmail();
        if (email == null) {
            throw new IllegalStateException("Unauthorized: no logged-in user");
        }

        Employee emp = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return requestRepo.findByEmployeeId(emp.getId());
    }

    //----------------------- ADMIN PART -----------------------------
    public String approveRequest(Long id) {
        NewAssetRequest req = requestRepo.findById(id).orElse(null);
        if (req == null || req.getStatus() != RequestStatus.PENDING) {
            return "Request not found or already processed.";
        }

        Asset asset = req.getAsset();

        boolean isAllocated = assetAllocationRepo.existsByAssetAndAllocationStatus(
            asset, AllocationStatus.ALLOCATED);

        if (isAllocated) {
            return "Asset is already allocated and not yet returned.";
        }

        // Approve and allocate
        req.setStatus(RequestStatus.APPROVED);
        requestRepo.save(req);

        AssetAllocation allocation = new AssetAllocation();
        allocation.setAsset(asset);
        allocation.setEmployee(req.getEmployee());
        allocation.setAllocationDate(LocalDate.now());
        allocation.setAllocationStatus(AllocationStatus.ALLOCATED);
        assetAllocationRepo.save(allocation);

        return "Request approved successfully and asset allocated.";
    }


    public String rejectRequest(Long id) {
        NewAssetRequest req = requestRepo.findById(id).orElse(null);
        if (req != null && req.getStatus() == RequestStatus.PENDING) {
            req.setStatus(RequestStatus.REJECTED);
            requestRepo.save(req);
            return "Request rejected successfully.";
        }
        return "Request not found or already processed.";
    }

    public String markRequestAsShipped(Long requestId) {
        NewAssetRequest req = requestRepo.findById(requestId).orElse(null);
        if (req == null) return "Request not found";
        if (req.getStatus() != RequestStatus.APPROVED) {
            return "Only approved requests can be marked as shipped.";
        }

        req.setStatus(RequestStatus.SHIPPED);
        requestRepo.save(req);
        return "Request marked as shipped successfully.";
    }

    public List<NewAssetRequest> getAllRequests() {
        return requestRepo.findAll();
    }

    private String getLoggedInUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
        return null;
    }
}
