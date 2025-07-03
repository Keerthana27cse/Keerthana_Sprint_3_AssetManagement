package com.example.assetmanagement.dto;

import com.example.assetmanagement.enums.AssetStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetDTO {
    private Long id;
    private String assetNo;
    private String assetName;
    private String assetModel;
    private String description;
    private String imageUrl;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private Double assetValue;
    private AssetStatus assetStatus;
    private Long categoryId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Customize as needed
    private LocalDateTime updatedAt;
    private String categoryName; // add this to DTO

}
