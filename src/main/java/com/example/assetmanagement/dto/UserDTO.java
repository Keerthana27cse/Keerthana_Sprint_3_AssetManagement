package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserRole userrole;
}
