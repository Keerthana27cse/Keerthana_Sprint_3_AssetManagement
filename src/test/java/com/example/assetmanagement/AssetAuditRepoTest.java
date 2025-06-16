package com.example.assetmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.AssetAudit;
import com.example.assetmanagement.model.AssetStatus;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.RequestStatus;
import com.example.assetmanagement.repository.AssetAuditRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.EmployeeRepo;


	@SpringBootTest
	
	public class AssetAuditRepoTest {

	    @Autowired
	    private AssetAuditRepo assetAuditRepo;

	    @Autowired
	    private EmployeeRepo employeeRepo;

	    @Autowired
	    private AssetRepo assetRepo;

	    @Test
	    void testSaveAndFetchAssetAudit() {
	        Employee emp = new Employee();
	        emp.setName("Keerthana");
	        emp.setEmail("keerthana@example.com");
	        emp.setPassword("password123");
	        Employee savedEmp = employeeRepo.save(emp);

	        Asset asset = new Asset();
	        asset.setAssetName("Chair");
	        asset.setAssetNo("CH01");
	        asset.setAssetModel("Executive");
	        asset.setAssetStatus(AssetStatus.WORKING); 
	        asset.setAssetValue(2000.0);
	        asset.setManufacturingDate(LocalDate.of(2022, 1, 1));
	        asset.setExpiryDate(LocalDate.of(2026, 1, 1));
	        Asset savedAsset = assetRepo.save(asset);

	        AssetAudit audit = new AssetAudit();
	        audit.setEmployee(savedEmp);
	        audit.setAsset(savedAsset);
	        audit.setRemarks("Initial Audit");
	        audit.setStatus(RequestStatus.APPROVED); 
	        audit.setAuditDate(LocalDate.now());

	        AssetAudit savedAudit = assetAuditRepo.save(audit);

	        assertNotNull(savedAudit.getId());
	        assertEquals("Initial Audit", savedAudit.getRemarks());
	        assertEquals(RequestStatus.APPROVED, savedAudit.getStatus());
	        assertEquals("Keerthana", savedAudit.getEmployee().getName());
	        assertEquals("Chair", savedAudit.getAsset().getAssetName());
	    }
	}

