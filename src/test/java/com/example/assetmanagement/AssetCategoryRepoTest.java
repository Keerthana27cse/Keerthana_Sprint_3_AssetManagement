package com.example.assetmanagement;

import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.repository.AssetCategoryRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AssetCategoryRepoTest {

    @Autowired
    private AssetCategoryRepo repo;

    @Test
    void testSaveAndFind() {
        AssetCategory category = new AssetCategory();
        category.setCategoryName("Electronics");

        AssetCategory saved = repo.save(category);

        assertNotNull(saved.getId());
        assertEquals("Electronics", saved.getCategoryName());
    }
}
