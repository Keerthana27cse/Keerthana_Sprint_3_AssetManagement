package com.example.assetmanagement.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    
    @NotBlank(message = "Username is required")
    private String email;
    
    @NotBlank(message = "Password is required")
    private String password;
}
