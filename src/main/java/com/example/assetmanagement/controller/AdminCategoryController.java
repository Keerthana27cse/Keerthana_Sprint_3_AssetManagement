package com.example.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assetmanagement.model.AssetCategory;
import com.example.assetmanagement.repository.AssetCategoryRepo;

@RequestMapping("/admin")
@Controller
public class AdminCategoryController {
	
    @Autowired private AssetCategoryRepo categoryRepo;

    // Show all assets
    
    
	@RequestMapping("/categories")//loads 
	public String viewAssetCategories(Model model) {
	    model.addAttribute("categories", categoryRepo.findAll());

	    if (!model.containsAttribute("category")) {
	        model.addAttribute("category", new AssetCategory()); 
	    }

	    return "categories"; 
	}
	@PostMapping("/saveCategory")//save
	public String saveCategory(@ModelAttribute("category") AssetCategory category, RedirectAttributes redirectAttributes) {
	    try {
	        categoryRepo.save(category);
	        redirectAttributes.addFlashAttribute("msg", 
	            (category.getId() == null ? "Category added" : "Category updated") + " successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("msg", "Error: " + e.getMessage());
	    }
	    return "redirect:/admin/categories";
	}
	@GetMapping("/editCategory")
	public String editCategory(@RequestParam("id") Long id, RedirectAttributes redirectAttributes, Model model) {
	    AssetCategory category = categoryRepo.findById(id).orElse(null);
	    if (category != null) {
	        redirectAttributes.addFlashAttribute("category", category); // pass to same JSP
	    } else {
	        redirectAttributes.addFlashAttribute("msg", "Invalid category ID");
	    }
	    return "redirect:/admin/categories";
	}
	@GetMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
	    try {
	        categoryRepo.deleteById(id);
	        redirectAttributes.addFlashAttribute("msg", "Category deleted successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("msg", "Could not delete category: " + e.getMessage());
	    }
	    return "redirect:/admin/categories";
	}
}
