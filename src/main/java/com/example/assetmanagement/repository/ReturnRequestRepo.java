package com.example.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetmanagement.entity.ReturnRequest;

public interface ReturnRequestRepo extends JpaRepository<ReturnRequest, Long> {

	List<ReturnRequest> findByEmployeeId(Long employeeId);

}
