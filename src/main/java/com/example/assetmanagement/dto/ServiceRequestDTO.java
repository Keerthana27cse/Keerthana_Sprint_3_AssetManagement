package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.IssueType;
import com.example.assetmanagement.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequestDTO {
    private Long id;
    private Long assetId;
    private Long employeeId;
    private IssueType issueType;
    private String description;
    private RequestStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime requestDate;

}
