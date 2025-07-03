package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.AssetDTO;
import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetCategory;

public class AssetMapper {

    public static AssetDTO toDTO(Asset asset) {
        if (asset == null) return null;

        return AssetDTO.builder()
                .id(asset.getId())
                .assetNo(asset.getAssetNo())
                .assetName(asset.getAssetName())
                .assetModel(asset.getAssetModel())
                .description(asset.getDescription())
                .imageUrl(asset.getImageUrl())
                .manufacturingDate(asset.getManufacturingDate())
                .expiryDate(asset.getExpiryDate())
                .assetValue(asset.getAssetValue())
                .assetStatus(asset.getAssetStatus())
                .categoryId(asset.getCategory() != null ? asset.getCategory().getId() : null)
                .categoryName(asset.getCategory().getCategoryName()) // ✅ ADD THIS
                .createdAt(asset.getCreatedAt()) // ✅ Here asset must come from DB (after save)
                .updatedAt(asset.getUpdatedAt())
                .build();
    }

    public static Asset toEntity(AssetDTO dto, AssetCategory category) {
        if (dto == null) return null;

        Asset asset = new Asset();
        asset.setId(dto.getId());
        asset.setAssetNo(dto.getAssetNo());
        asset.setAssetName(dto.getAssetName());
        asset.setAssetModel(dto.getAssetModel());
        asset.setDescription(dto.getDescription());
        asset.setImageUrl(dto.getImageUrl());
        asset.setManufacturingDate(dto.getManufacturingDate());
        asset.setExpiryDate(dto.getExpiryDate());
        asset.setAssetValue(dto.getAssetValue());
        asset.setAssetStatus(dto.getAssetStatus());
        asset.setCategory(category);
       
        return asset;
    }
}
