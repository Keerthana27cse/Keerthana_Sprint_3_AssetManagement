package com.example.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.NewAssetRequest;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.NewAssetRequestRepo;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmpNewReqController {

    @Autowired
    private NewAssetRequestRepo newAssetRequestRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employee-new-requests")
    public String viewMyNewAssetRequests(@RequestParam("employeeId") Long employeeId, Model model) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        List<NewAssetRequest> requests = newAssetRequestRepo.findByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("requests", requests);

        return "employee-new-requests"; // JSP view
    }
}
