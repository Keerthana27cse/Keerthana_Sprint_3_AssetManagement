package com.example.assetmanagement.restapi;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assetmanagement.enums.IssueType;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.NewAssetRequest;
import com.example.assetmanagement.model.ServiceRequest;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.AssetRepo;
import com.example.assetmanagement.repository.NewAssetRequestRepo;
import com.example.assetmanagement.repository.ServiceRequestRepo;
@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
	
	    @Autowired private AssetRepo assetRepo;
	    @Autowired private AssetCategoryRepo categoryRepo;
	    @Autowired private NewAssetRequestRepo newAssetRequestRepo;
	    @Autowired private ServiceRequestRepo serviceRequestRepo;

@GetMapping("/employee/assets")
public ResponseEntity<List<Asset>> viewAssets(@RequestParam(required = false) Long category,
                                              @RequestParam(required = false) String search) {
    List<Asset> assets;
    if (category != null) {
        assets = assetRepo.findByCategory_Id(category);
    } else if (search != null) {
        assets = assetRepo.findByAssetNameContainingIgnoreCase(search);
    } else {
        assets = assetRepo.findAll();
    }
    return ResponseEntity.ok(assets);
}

@GetMapping("/employee/assets/{id}")
public ResponseEntity<Asset> viewAssetDetails(@PathVariable Long id) {
    return assetRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping("/employee/request-new")
public ResponseEntity<?> submitNewAssetRequest(@RequestBody NewAssetRequest request) {
    request.setStatus(RequestStatus.PENDING);
    request.setRequestDate(LocalDate.now());
    newAssetRequestRepo.save(request);
    return ResponseEntity.ok(Map.of("message", "New asset request submitted"));
}
/*{
  "employeeName": "Keerthana",
  "assetName": "Laptop",
  "category": {
    "id": 1,
    "categoryName": "Electronics"
  },
  "reason": "Required for software development"
}
*/

@PostMapping("/employee/request-service")
public ResponseEntity<?> submitServiceRequest(@RequestBody Map<String, Object> data) {
    Long assetId = Long.valueOf(data.get("assetId").toString());
    String description = data.get("description").toString();
    String issueType = data.get("issueType").toString();

    Asset asset = assetRepo.findById(assetId).orElseThrow(() -> new RuntimeException("Asset not found"));

    ServiceRequest request = new ServiceRequest();
    request.setAsset(asset);
    request.setDescription(description);
    request.setIssueType(IssueType.valueOf(issueType));
    request.setRequestDate(LocalDate.now());
    request.setStatus(RequestStatus.PENDING);

    serviceRequestRepo.save(request);

    return ResponseEntity.ok(Map.of("message", "Service request submitted"));

}
/*{
 * 
 */
}