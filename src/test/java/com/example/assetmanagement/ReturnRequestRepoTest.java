package com.example.assetmanagement;

import com.example.assetmanagement.model.ReturnRequest;
import com.example.assetmanagement.repository.ReturnRequestRepo;
import com.example.assetmanagement.model.RequestStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ReturnRequestRepoTest {

    @Autowired
    private ReturnRequestRepo repo;

    @Test
    void testSaveReturnRequest() {
        ReturnRequest returnRequest = new ReturnRequest();
        returnRequest.setRequestDate(LocalDate.now());
        returnRequest.setStatus(RequestStatus.APPROVED);

        ReturnRequest saved = repo.save(returnRequest);

        assertNotNull(saved.getId());
        assertEquals(RequestStatus.APPROVED, saved.getStatus());
    }
}
