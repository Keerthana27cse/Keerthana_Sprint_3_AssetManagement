package com.example.assetmanagement.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetCategoryDTO {
    private Long id;
    private String categoryName;
    // You can include a Set<Long> assetIds if needed, but usually omitted in DTO
}
