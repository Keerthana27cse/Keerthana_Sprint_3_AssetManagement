package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.EmployeeDTO;
import com.example.assetmanagement.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee emp) {
        if (emp == null) return null;

        return EmployeeDTO.builder()
                .id(emp.getId())
                .username(emp.getUsername())
                .name(emp.getName())
                .email(emp.getEmail())
                .contactNumber(emp.getContactNumber())
                .address(emp.getAddress())
                .gender(emp.getGender())
                .role(emp.getRole())
                .empstatus(emp.getEmpstatus())
                .createdAt(emp.getCreatedAt())
                .build();
    }

    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setUsername(dto.getUsername());
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setContactNumber(dto.getContactNumber());
        emp.setAddress(dto.getAddress());
        emp.setGender(dto.getGender());
        emp.setRole(dto.getRole());
        emp.setEmpstatus(dto.getEmpstatus());
        return emp;
    }
}
