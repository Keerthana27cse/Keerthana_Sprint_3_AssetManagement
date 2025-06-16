package com.example.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.model.ServiceRequest;

public interface ServiceRequestRepo extends JpaRepository<ServiceRequest, Long> {

}
