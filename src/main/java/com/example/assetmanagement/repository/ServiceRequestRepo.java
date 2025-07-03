package com.example.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.entity.ServiceRequest;

public interface ServiceRequestRepo extends JpaRepository<ServiceRequest, Long> {

    List<ServiceRequest> findByEmployeeId(Long employeeId);  // accepts employeeId

}
