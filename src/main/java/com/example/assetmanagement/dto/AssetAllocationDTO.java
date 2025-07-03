package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.AllocationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetAllocationDTO {
    private Long id;
    private Long assetId;
    private Long employeeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed

    private LocalDateTime requestDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed

    private LocalDate allocationDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed

    private LocalDate returnDate;
    private AllocationStatus allocationStatus;
}
