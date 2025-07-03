package com.example.assetmanagement;

import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.NewAssetRequest;
import com.example.assetmanagement.enums.AssetStatus;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.NewAssetRequestRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AssetAllocationRepoTest {

	@Autowired
    private NewAssetRequestRepo newAssetRequestRepo;

    @Autowired
    private AssetRepo assetRepo;

    
    @Autowired
    private AssetAllocationRepo assetAllocationRepo;

    @Test
    public void testAllocateAssetForRequest() {
        // 1. Fetch NewAssetRequest by id
        Long requestId = 4L;
        NewAssetRequest request = newAssetRequestRepo.findById(requestId).orElseThrow();

        // 2. Get requested category id
        Long categoryId = request.getRequestedCategory().getId();

        // 3. Find an available asset in that category with status WORKING
        Asset asset = assetRepo.findFirstByCategory_IdAndAssetStatus(categoryId, AssetStatus.WORKING)
                .orElseThrow(() -> new RuntimeException("No available asset found"));


        // 4. Create asset allocation
        AssetAllocation allocation = new AssetAllocation();
        allocation.setAsset(asset);
        allocation.setEmployee(request.getEmployee());
        allocation.setAllocationDate(LocalDate.now());
        allocation.setReturnDate(null);

        AssetAllocation savedAllocation = assetAllocationRepo.save(allocation);

        // 5. Optionally update request status
        request.setStatus(RequestStatus.APPROVED);
        newAssetRequestRepo.save(request);

        // Assertions
        assertNotNull(savedAllocation.getId());
        assertEquals(request.getEmployee().getId(), savedAllocation.getEmployee().getId());
        assertEquals(asset.getId(), savedAllocation.getAsset().getId());
        assertEquals(RequestStatus.APPROVED, request.getStatus());
    }
}