package com.example.assetmanagement.dto;

import java.sql.Timestamp;

import com.example.assetmanagement.enums.EmployeeStatus;
import com.example.assetmanagement.enums.Gender;
import com.example.assetmanagement.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private Gender gender;
    private UserRole role;
    private EmployeeStatus empstatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private Timestamp createdAt;

    
}
