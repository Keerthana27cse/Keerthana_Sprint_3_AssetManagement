package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.AssetAuditDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAudit;
import com.example.assetmanagement.entity.Employee;

public class AssetAuditMapper {

    public static AssetAuditDTO toDTO(AssetAudit audit) {
        if (audit == null) return null;

        return AssetAuditDTO.builder()
                .id(audit.getId())
                .employeeId(audit.getEmployee().getId())
                .assetId(audit.getAsset().getId())
                .remarks(audit.getRemarks())
                .status(audit.getStatus())
                .auditDate(audit.getAuditDate())
                .build();
    }

    public static AssetAudit toEntity(AssetAuditDTO dto, Employee employee, Asset asset) {
        if (dto == null) return null;

        AssetAudit audit = new AssetAudit();
        audit.setId(dto.getId());
        audit.setEmployee(employee);
        audit.setAsset(asset);
        audit.setRemarks(dto.getRemarks());
        audit.setStatus(dto.getStatus());
        audit.setAuditDate(dto.getAuditDate());
        return audit;
    }
}
