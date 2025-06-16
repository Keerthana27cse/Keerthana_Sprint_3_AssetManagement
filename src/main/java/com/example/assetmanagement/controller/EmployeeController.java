package com.example.assetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@GetMapping("/dashboard")
	public String employeeDashboard()
	{
		return "employeeDashboard";
	}
	
	@GetMapping("/requestAsset")
	public String requestAsset()
	{
		return "requestAsset";
	}
	@GetMapping("/assetCatalogue")
	public String assetCatalogue()
	{
		return "requestAsset";
	}
}