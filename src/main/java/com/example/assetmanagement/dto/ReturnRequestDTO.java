package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReturnRequestDTO {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private Long assetId;
    private String assetName;
    private String reason;
    private RequestStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime requestDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime returnDate;
}
