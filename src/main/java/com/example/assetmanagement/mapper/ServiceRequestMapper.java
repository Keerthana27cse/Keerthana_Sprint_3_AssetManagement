package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.ServiceRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.ServiceRequest;

public class ServiceRequestMapper {

    public static ServiceRequestDTO toDTO(ServiceRequest request) {
        if (request == null) return null;

        return ServiceRequestDTO.builder()
                .id(request.getId())
                .assetId(request.getAsset().getId())
                .employeeId(request.getEmployee().getId())
                .issueType(request.getIssueType())
                .description(request.getDescription())
                .status(request.getStatus())
                .requestDate(request.getRequestDate())
                .build();
    }

    public static ServiceRequest toEntity(ServiceRequestDTO dto, Asset asset, Employee employee) {
        if (dto == null) return null;

        ServiceRequest request = new ServiceRequest();
        request.setId(dto.getId());
        request.setAsset(asset);
        request.setEmployee(employee);
        request.setIssueType(dto.getIssueType());
        request.setDescription(dto.getDescription());
        request.setStatus(dto.getStatus());
        request.setRequestDate(dto.getRequestDate());
        return request;
    }
}
