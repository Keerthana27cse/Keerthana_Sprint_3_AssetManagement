package com.example.assetmanagement;

import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.AssetAllocation;
import com.example.assetmanagement.model.AssetStatus;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.UserRole;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AssetAllocationRepoTest {

    @Autowired
    private AssetAllocationRepo assetAllocationRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void testSaveAndFindAssetAllocation() {
        
    	Asset asset = new Asset();
        asset.setAssetNo("A001");
        asset.setAssetName("Laptop");
        asset.setAssetModel("Dell XPS");
        asset.setManufacturingDate(LocalDate.of(2023, 1, 1));
        asset.setExpiryDate(LocalDate.of(2028, 1, 1));
        asset.setAssetStatus(AssetStatus.valueOf("WORKING"));
        asset.setAssetValue(100000.0);
        asset = assetRepo.save(asset);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setEmail("john@example.com");
        emp.setPassword("test123");
        emp.setRole(UserRole.valueOf("EMPLOYEE"));
        emp.setContactNumber("1234567890");
        emp = employeeRepo.save(emp);

        AssetAllocation allocation = new AssetAllocation();
        allocation.setAsset(asset);
        allocation.setEmployee(emp);
        allocation.setAllocationDate(LocalDate.now());
        allocation.setReturnDate(LocalDate.now().plusDays(30));

        AssetAllocation saved = assetAllocationRepo.save(allocation);
        assertNotNull(saved.getId());

        AssetAllocation found = assetAllocationRepo.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(emp.getEmail(), found.getEmployee().getEmail());
        assertEquals(asset.getAssetNo(), found.getAsset().getAssetNo());
    }
}

    /*@AfterEach
    public void cleanup() {
        assetAllocationRepo.deleteAll();
        assetRepo.deleteAll();
        employeeRepo.deleteAll();*/

