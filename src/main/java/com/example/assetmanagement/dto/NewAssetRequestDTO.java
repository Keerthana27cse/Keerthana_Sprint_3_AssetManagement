package com.example.assetmanagement.dto;

import java.time.LocalDateTime;

import com.example.assetmanagement.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewAssetRequestDTO {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private Long requestedCategoryId;
    private String categoryName;
    private Long assetId;  // nullable if new asset requested
    private String assetName;
    private String description;
    private String requestReason;
    private RequestStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime requestDate;
    // Shipping info
    private String fullAddress;
    private String zipCode;
    private String phone;

}
