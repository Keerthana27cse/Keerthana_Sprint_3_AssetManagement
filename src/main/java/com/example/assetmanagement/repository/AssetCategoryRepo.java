package com.example.assetmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.AssetCategory;

public interface AssetCategoryRepo extends JpaRepository<AssetCategory, Long> {


}

