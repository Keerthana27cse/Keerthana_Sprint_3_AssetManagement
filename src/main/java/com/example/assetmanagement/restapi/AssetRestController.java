package com.example.assetmanagement.restapi;

import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.repository.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
public class AssetRestController {

    @Autowired
    private AssetRepo assetRepo;

    

    // all asset
    @GetMapping("/")
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        Optional<Asset> asset = assetRepo.findById(id);
        return asset.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<List<Asset>> updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset) {
        Optional<Asset> optional = assetRepo.findById(id);
        if (optional.isPresent()) {
            Asset asset = optional.get();
            asset.setAssetNo(updatedAsset.getAssetNo());
            asset.setAssetName(updatedAsset.getAssetName());
            asset.setAssetModel(updatedAsset.getAssetModel());
            asset.setManufacturingDate(updatedAsset.getManufacturingDate());
            asset.setExpiryDate(updatedAsset.getExpiryDate());
            asset.setAssetValue(updatedAsset.getAssetValue());
            asset.setAssetStatus(updatedAsset.getAssetStatus());
            asset.setCategory(updatedAsset.getCategory());

            assetRepo.save(asset);
            return ResponseEntity.ok(assetRepo.findAll());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // save
    @PostMapping("/")
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset saved = assetRepo.save(asset);
        return ResponseEntity.ok(saved);
    }

    
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable Long id) {
        Optional<Asset> asset = assetRepo.findById(id);
        if (asset.isPresent()) {
            assetRepo.deleteById(id);
            return ResponseEntity.ok("Asset deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //filter
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Asset>> filterAssetsByCategory(@PathVariable Long categoryId) {
        if (categoryId == 0) {
            return ResponseEntity.ok(assetRepo.findAll());
        } else {
            return ResponseEntity.ok(assetRepo.findByCategory_Id(categoryId));
        }
    }
}
/*{
  "assetNo": "ASSET-1023",
  "assetName": "Dell Laptop",
  "assetModel": "Inspiron 14 5000",
  "manufacturingDate": "2022-05-10",
  "expiryDate": "2027-05-10",
  "assetValue": 75000.00,
  "assetStatus": "AVAILABLE",
  "category": {
    "id": 1,
    "categoryName": "Electronics"
  }
}
*/

