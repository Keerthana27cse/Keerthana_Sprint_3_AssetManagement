package com.example.assetmanagement.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.entity.AssetCategory;

public interface AssetCategoryRepo extends JpaRepository<AssetCategory, Long> {

	Optional<AssetCategory> findByCategoryName(String categoryName);

}

