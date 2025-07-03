package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.ReturnRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.ReturnRequest;

public class ReturnRequestMapper {

    public static ReturnRequestDTO toDTO(ReturnRequest request) {
        if (request == null) return null;

        return ReturnRequestDTO.builder()
                .id(request.getId())
                .employeeId(request.getEmployee().getId())
                .employeeName(request.getEmployee().getName())  // 👈 add this line
                .assetId(request.getAsset().getId())
                .assetName(request.getAsset() != null ? request.getAsset().getAssetName() : null)
                .reason(request.getReason())
                .status(request.getStatus())
                .requestDate(request.getRequestDate())
                .returnDate(request.getReturnDate())
                .build();
    }

    public static ReturnRequest toEntity(ReturnRequestDTO dto, Asset asset, Employee employee) {
        if (dto == null) return null;

        ReturnRequest request = new ReturnRequest();
        request.setId(dto.getId());
        request.setEmployee(employee);
        request.setAsset(asset);
        request.setReason(dto.getReason());
        request.setStatus(dto.getStatus());
        request.setRequestDate(dto.getRequestDate());
        request.setReturnDate(dto.getReturnDate());
        return request;
    }
}
