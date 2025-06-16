package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.Asset;

public interface AssetRepo extends JpaRepository<Asset, Long> {

}
