package com.example.assetmanagement;

import com.example.assetmanagement.model.NewAssetRequest;
import com.example.assetmanagement.model.RequestStatus;
import com.example.assetmanagement.repository.NewAssetRequestRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class NewAssetRequestRepoTest {

    @Autowired
    private NewAssetRequestRepo repo;

    @Test
    void testSaveAndFetch() {
        NewAssetRequest request = new NewAssetRequest();
        request.setRequestDate(LocalDate.now());
        request.setStatus(RequestStatus.PENDING);

        NewAssetRequest saved = repo.save(request);

        assertNotNull(saved.getId());
        assertEquals(RequestStatus.PENDING, saved.getStatus());
    }
}
