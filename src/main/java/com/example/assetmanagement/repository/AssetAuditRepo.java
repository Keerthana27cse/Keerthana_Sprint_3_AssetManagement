package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.AssetAudit;

public interface AssetAuditRepo extends JpaRepository<AssetAudit, Long> {
	

}
