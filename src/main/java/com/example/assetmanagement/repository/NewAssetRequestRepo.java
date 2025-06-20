package com.example.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.model.NewAssetRequest;

public interface NewAssetRequestRepo extends JpaRepository<NewAssetRequest, Long> {

	Optional<NewAssetRequest> findFirstByRequestedCategory_IdAndStatus(Long categoryId, RequestStatus status);
    List<NewAssetRequest> findByEmployeeId(Long employeeId);


}
