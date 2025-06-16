package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.ReturnRequest;

public interface ReturnRequestRepo extends JpaRepository<ReturnRequest, Long> {

}
