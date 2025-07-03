package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.NewAssetRequestDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetCategory;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.entity.NewAssetRequest;

public class NewAssetRequestMapper {

    public static NewAssetRequestDTO toDTO(NewAssetRequest request) {
        if (request == null) return null;

        return NewAssetRequestDTO.builder()
                .id(request.getId())
                .employeeId(request.getEmployee().getId())
                .employeeName(request.getEmployee().getName())  // 👈 add this line
                .requestedCategoryId(request.getRequestedCategory().getId())
                .categoryName(request.getRequestedCategory().getCategoryName()) // ✅ ADD THIS
                .assetId(request.getAsset() != null ? request.getAsset().getId() : null)
                .assetName(request.getAsset() != null ? request.getAsset().getAssetName() : null)
                .description(request.getDescription())
                .requestReason(request.getRequestReason())
                .status(request.getStatus())
                .requestDate(request.getRequestDate())
                .fullAddress(request.getFullAddress())
                .zipCode(request.getZipCode())
                .phone(request.getPhone())
                .build();
    }
    

    public static NewAssetRequest toEntity(NewAssetRequestDTO dto, Employee employee, AssetCategory category, Asset asset) {
        if (dto == null) return null;

        NewAssetRequest request = new NewAssetRequest();
        request.setId(dto.getId());
        request.setEmployee(employee);
        request.setRequestedCategory(category);
        request.setAsset(asset);  // can be null
        request.setDescription(dto.getDescription());
        request.setRequestReason(dto.getRequestReason());
        request.setStatus(dto.getStatus());
        request.setRequestDate(dto.getRequestDate());

        // Set shipping details
        request.setFullAddress(dto.getFullAddress());
        request.setZipCode(dto.getZipCode());
        request.setPhone(dto.getPhone());

        return request;
    }
}
