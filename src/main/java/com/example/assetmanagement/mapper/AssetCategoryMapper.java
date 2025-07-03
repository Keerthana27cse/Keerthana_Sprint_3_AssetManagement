package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.AssetCategoryDTO;
import com.example.assetmanagement.entity.AssetCategory;

public class AssetCategoryMapper {

    public static AssetCategoryDTO toDTO(AssetCategory category) {
        if (category == null) return null;

        return AssetCategoryDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }

    public static AssetCategory toEntity(AssetCategoryDTO dto) {
        if (dto == null) return null;

        AssetCategory category = new AssetCategory();
        category.setId(dto.getId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }
}
