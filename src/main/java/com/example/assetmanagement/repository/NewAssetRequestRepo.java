package com.example.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.assetmanagement.entity.NewAssetRequest;

public interface NewAssetRequestRepo extends JpaRepository<NewAssetRequest, Long> {

    List<NewAssetRequest> findByEmployeeId(Long employeeId);

 // Count allocated (approved + asset is not null)
    @Query("SELECT COUNT(n) FROM new_asset_request n WHERE n.status = 'APPROVED' AND n.asset IS NOT NULL")
    long countAllocatedAssets();

    // List all allocated requests
    @Query("SELECT n FROM new_asset_request n WHERE n.status = 'APPROVED' AND n.asset IS NOT NULL")
    List<NewAssetRequest> findAllocatedAssets();
}
