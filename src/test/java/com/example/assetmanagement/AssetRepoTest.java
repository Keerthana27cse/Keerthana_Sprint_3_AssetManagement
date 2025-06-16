package com.example.assetmanagement;

import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.AssetStatus;
import com.example.assetmanagement.repository.AssetRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AssetRepoTest {

    @Autowired
    private AssetRepo repo;

    @Test
    void testSaveAndFindAsset() {
        Asset asset = new Asset();
        asset.setAssetNo("A001");
        asset.setAssetName("Projector");
        asset.setAssetModel("X100");
        asset.setAssetStatus(AssetStatus.WORKING);
        asset.setAssetValue(5000.0);
        asset.setManufacturingDate(LocalDate.of(2022, 1, 1));
        asset.setExpiryDate(LocalDate.of(2026, 1, 1));

        Asset saved = repo.save(asset);

        assertNotNull(saved.getId());
        assertEquals("Projector", saved.getAssetName());
    }
}
