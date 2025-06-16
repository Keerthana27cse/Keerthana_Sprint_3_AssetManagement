package com.example.assetmanagement;

import com.example.assetmanagement.model.ServiceRequest;
import com.example.assetmanagement.repository.ServiceRequestRepo;
import com.example.assetmanagement.model.RequestStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceRequestRepoTest {

    @Autowired
    private ServiceRequestRepo repo;

    @Test
    void testSaveServiceRequest() {
        ServiceRequest request = new ServiceRequest();
        request.setRequestDate(LocalDate.now());
        request.setStatus(RequestStatus.VERIFIED);

        ServiceRequest saved = repo.save(request);

        assertNotNull(saved.getId());
        assertEquals(RequestStatus.VERIFIED,saved.getStatus());
    }
}
