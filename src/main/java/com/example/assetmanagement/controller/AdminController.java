package com.example.assetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.repository.EmployeeRepo;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired private EmployeeRepo emprepo; 
	
	
	@RequestMapping("/dashboard")
	public String adminDashBoard(Model model) {
	List<Employee> l1=emprepo.findAll();
	model.addAttribute("EmpDetails",l1);
		return "adminDashboard";
	}
	
	

	@GetMapping("delete")
	public String delete(@RequestParam Long id,RedirectAttributes  redirectAttributes)
	{
		emprepo.deleteById(id);
		redirectAttributes.addFlashAttribute("msg","Employee  Deleted");
		return "redirect:/admin/dashboard";
	}
	
	  @RequestMapping("/viewAllocatedAssets")
	    public String viewAllocatedAssets(Model model) {
	        return "viewAllocatedAssets"; 
	    }

	    @RequestMapping("/viewRequestedAssets")
	    public String viewRequestedAssets(Model model) {
	        return "viewRequestedAssets";
	    }

	    @RequestMapping("/allocateAsset")
	    public String allocateAsset(Model model) {
	        return "allocateAsset";
	    }

	    @RequestMapping("/assetCatalogue")
	    public String assetCatalogue(Model model) {
	        return "assetCatalogue";
	    }
	}

	