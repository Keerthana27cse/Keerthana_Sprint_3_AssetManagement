package com.example.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.enums.AssetStatus;
import com.example.assetmanagement.model.Asset;

public interface AssetRepo extends JpaRepository<Asset, Long> {

	Optional<Asset> findByAssetNo(String assetNo);

    // Find all assets belonging to a given category id

    // For search, you might add (example by assetName containing keyword)
    List<Asset> findByAssetNameContainingIgnoreCase(String keyword);

    Optional<Asset> findFirstByCategory_IdAndAssetStatus(Long categoryId, AssetStatus assetStatus);

	List<Asset> findByCategory_Id(Long categoryId);
}
