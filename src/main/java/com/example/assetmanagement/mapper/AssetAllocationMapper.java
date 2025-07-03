package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.AssetAllocationDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.Employee;

public class AssetAllocationMapper {

    public static AssetAllocationDTO toDTO(AssetAllocation allocation) {
        if (allocation == null) return null;

        return AssetAllocationDTO.builder()
                .id(allocation.getId())
                .assetId(allocation.getAsset().getId())
                .employeeId(allocation.getEmployee().getId())
                .requestDate(allocation.getRequestDate())
                .allocationDate(allocation.getAllocationDate())
                .returnDate(allocation.getReturnDate())
                .allocationStatus(allocation.getAllocationStatus())
                .build();
    }

    public static AssetAllocation toEntity(AssetAllocationDTO dto, Employee employee, Asset asset) {
        if (dto == null) return null;

        AssetAllocation allocation = new AssetAllocation();
        allocation.setId(dto.getId());
        allocation.setEmployee(employee);
        allocation.setAsset(asset);
        allocation.setRequestDate(dto.getRequestDate());
        allocation.setAllocationDate(dto.getAllocationDate());
        allocation.setReturnDate(dto.getReturnDate());
        allocation.setAllocationStatus(dto.getAllocationStatus());
        return allocation;
    }
}
