package com.example.assetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assetmanagement.model.Asset;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.AssetRepo;

@Controller
@RequestMapping("/admin")
public class AdminAssetController {

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private AssetCategoryRepo categoryRepo;

    
    
    @GetMapping("/assetCatalogue")
    public String viewAssets(Model model) {
        model.addAttribute("assets", assetRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("selectedCategoryId", 0L);
        model.addAttribute("asset", new Asset());
        return "asset-catalogue";
    }


    // Save or update asset
    @PostMapping("/saveAsset")
    public String saveAsset(@ModelAttribute Asset asset, RedirectAttributes ra) {
        assetRepo.save(asset);
        ra.addFlashAttribute("msg", "Asset saved successfully!");
        return "redirect:/admin/assetCatalogue";
    }

    @GetMapping("/editAsset")
    public String editAsset(@RequestParam("id") Long id, Model model) {
        Asset asset = assetRepo.findById(id).orElse(null);
        if (asset == null) {
            model.addAttribute("msg", "Invalid asset ID");
            asset = new Asset();  //if empty
        }
        model.addAttribute("asset", asset);
        model.addAttribute("assets", assetRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("selectedCategoryId", 0L);  // or you can keep track of selected category
        return "asset-catalogue";  // forward to JSP (not redirect)
    }

    // Delete asset
    @GetMapping("/deleteAsset")
    public String deleteAsset(@RequestParam("id") Long id, RedirectAttributes ra) {
        assetRepo.deleteById(id);
        ra.addFlashAttribute("msg", "Asset deleted successfully!");
        return "redirect:/admin/assetCatalogue";
    }
    
    @GetMapping("/filterAssets")
    public String filterAssets(@RequestParam("categoryId") Long categoryId, Model model) {
        List<Asset> assets;

        if (categoryId == 0) {
            assets = assetRepo.findAll(); // 0 means "All"
        } else {
            
            assets = assetRepo.findByCategory_Id(categoryId);
        }

        model.addAttribute("assets", assets);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("asset", new Asset()); // for form
        return "asset-catalogue";
    }

}
