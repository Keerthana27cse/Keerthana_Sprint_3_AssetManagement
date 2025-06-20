package com.example.assetmanagement;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.assetmanagement.enums.AssetStatus;
import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.AssetRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetRepoTest {

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private AssetCategoryRepo categoryRepo;

    @Test
    public void testSaveAndFindByAssetNo() {
        AssetCategory category = new AssetCategory("Electronics");
        category = categoryRepo.save(category);

        Asset asset = new Asset();
        asset.setAssetNo("A123");
        asset.setAssetName("Projector");
        asset.setAssetModel("X100");
        asset.setManufacturingDate(LocalDate.of(2022, 1, 1));
        asset.setExpiryDate(LocalDate.of(2026, 1, 1));
        asset.setAssetValue(5000.0);
        asset.setAssetStatus(AssetStatus.WORKING);
        asset.setCategory(category);

        Asset saved = assetRepo.save(asset);
        assertThat(saved.getId()).isNotNull();

        Optional<Asset> found = assetRepo.findByAssetNo("A123");
        assertThat(found).isPresent();
        assertThat(found.get().getAssetName()).isEqualTo("Projector");
    }

    @Test
    public void testFindByCategoryId() {
        AssetCategory category = new AssetCategory("Furniture");
        category = categoryRepo.save(category);

        Asset asset1 = new Asset("F001", "Office Chair", category);
        Asset asset2 = new Asset("F002", "Office Table", category);

        assetRepo.save(asset1);
        assetRepo.save(asset2);

        List<Asset> furnitureAssets = assetRepo.findByCategoryId(category.getId());
        assertThat(furnitureAssets).hasSize(2);
    }

    @Test
    public void testFindByAssetNameContainingIgnoreCase() {
        AssetCategory category = new AssetCategory("Gadgets");
        category = categoryRepo.save(category);

        Asset asset = new Asset("G001", "Smartphone", category);
        assetRepo.save(asset);

        List<Asset> foundAssets = assetRepo.findByAssetNameContainingIgnoreCase("phone");
        assertThat(foundAssets).isNotEmpty();
        assertThat(foundAssets.get(0).getAssetName()).isEqualTo("Smartphone");
    }
}
