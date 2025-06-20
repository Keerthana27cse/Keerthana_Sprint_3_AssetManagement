package com.example.assetmanagement.restapi;


import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryRestController {

    @Autowired
    private AssetCategoryRepo categoryRepo;

    @GetMapping 
    public ResponseEntity<List<AssetCategory>> getAllCategories() {
        List<AssetCategory> categories = categoryRepo.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping // (only names enough)
    public ResponseEntity<String> addCategory(@RequestBody AssetCategory category) {
        try {
            categoryRepo.save(category);
            return ResponseEntity.ok("Category added successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody AssetCategory category) {
        if (!categoryRepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Invalid category ID.");
        }

        category.setId(id); // ensure correct ID
        categoryRepo.save(category);
        return ResponseEntity.ok("Category updated successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetCategory> getCategoryById(@PathVariable Long id) {
        return categoryRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        try {
            if (!categoryRepo.existsById(id)) {
                return ResponseEntity.badRequest().body("Invalid category ID.");
            }
            categoryRepo.deleteById(id);
            return ResponseEntity.ok("Category deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not delete category: " + e.getMessage());
        }
    }
}
