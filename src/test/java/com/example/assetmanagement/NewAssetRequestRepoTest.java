package com.example.assetmanagement;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.NewAssetRequest;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.NewAssetRequestRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NewAssetRequestRepoTest {

    @Autowired
    private NewAssetRequestRepo requestRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AssetCategoryRepo categoryRepo;

    @Test
    void testSaveNewAssetRequest() {
        // Fetch employee and category from DB
        Employee employee = employeeRepo.findById(1L).orElseThrow();
        AssetCategory category = categoryRepo.findById(3L).orElseThrow(); // Gadgets

        // Create new request
        NewAssetRequest request = new NewAssetRequest();
        request.setEmployee(employee);
        request.setRequestedCategory(category);
        request.setDescription("Need a new smartphone for testing purpose");
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(LocalDate.now());

        NewAssetRequest saved = requestRepo.save(request);

        assertNotNull(saved.getId());
        assertEquals(RequestStatus.PENDING, saved.getStatus());
        assertEquals("Gadgets", saved.getRequestedCategory().getCategoryName());
        assertEquals("Keerthana", saved.getEmployee().getName());
    }
}
