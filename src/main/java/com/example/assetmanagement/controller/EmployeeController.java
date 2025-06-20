package com.example.assetmanagement.controller;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.model.NewAssetRequest;
import com.example.assetmanagement.model.ServiceRequest;
import com.example.assetmanagement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private AssetCategoryRepo categoryRepo;

    @Autowired
    private NewAssetRequestRepo newAssetRequestRepo;

    @Autowired
    private ServiceRequestRepo serviceRequestRepo;

        
    @RequestMapping("/dashboard")
	public String showadmindashboard() {
        return "employeeDashboard"; 
    }
	
    // a. List all assets with optional filters/search
    @GetMapping("/assets")
    public String viewAssets(
            @RequestParam(value = "category", required = false) Long categoryId,
            @RequestParam(value = "search", required = false) String search,
            Model model) {

        List<AssetCategory> categories = categoryRepo.findAll();
        List<Asset> assets;

        if (categoryId != null) {
            assets = assetRepo.findByCategory_Id(categoryId);
            model.addAttribute("selectedCategoryId", categoryId); // 🔍 this line retains selection
        } else if (search != null && !search.isEmpty()) {
            assets = assetRepo.findByAssetNameContainingIgnoreCase(search);
        } else {
            assets = assetRepo.findAll();
        }

        model.addAttribute("assets", assets);
        model.addAttribute("categories", categories);
        return "employee-assets"; // JSP view
    }
   

    // b. View asset details
    @GetMapping("/asset/{id}")
    public String viewAssetDetails(@PathVariable Long id, Model model) {
        Asset asset = assetRepo.findById(id).orElseThrow();
        model.addAttribute("asset", asset);
        return "asset-details"; // JSP view
    }

    // c. Raise new asset request (GET)
    @GetMapping("/request-new")
    public String requestNewAssetForm(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("newAssetRequest", new NewAssetRequest());
        return "new-asset-request"; // JSP view
    }

    // c. Submit new asset request (POST)
    @PostMapping("/request-new")
    public String submitNewAssetRequest(@ModelAttribute NewAssetRequest request) {
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(java.time.LocalDate.now());
        newAssetRequestRepo.save(request);
        return "redirect:/employee/assets";
    }

    // d. Raise service request (GET)
    @GetMapping("/request-service")
    public String requestServiceForm(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "service-request-form"; // JSP view
    }

    // d. Submit service request (POST)
    @PostMapping("/request-service")
    public String submitServiceRequest(@ModelAttribute ServiceRequest request) {
        request.setRequestDate(java.time.LocalDate.now());
        request.setStatus(RequestStatus.PENDING);
        serviceRequestRepo.save(request);
        return "redirect:/employee/assets";
    }
}
