package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.AssetAllocation;

public interface AssetAllocationRepo extends JpaRepository<AssetAllocation, Long> {

}
