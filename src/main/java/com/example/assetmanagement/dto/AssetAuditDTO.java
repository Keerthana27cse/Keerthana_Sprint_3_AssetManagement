package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.RequestStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetAuditDTO {
    private Long id;
    private Long employeeId;
    private Long assetId;
    private String remarks;
    private RequestStatus status;
    private LocalDate auditDate;
}
