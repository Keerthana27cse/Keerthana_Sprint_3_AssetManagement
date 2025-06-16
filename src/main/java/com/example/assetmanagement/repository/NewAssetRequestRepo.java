package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.NewAssetRequest;

public interface NewAssetRequestRepo extends JpaRepository<NewAssetRequest, Long> {

}
