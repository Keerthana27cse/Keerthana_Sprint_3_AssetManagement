package com.example.assetmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.repository.EmployeeRepo;
@Controller
@RequestMapping("/admin")
public class AdminEmpController {
	

	@Autowired private EmployeeRepo emprepo; 
	
	@RequestMapping("/dashboard")
	public String showadmindashboard() {
        return "adminDashboard"; 
    }
	
	@RequestMapping("/EmployeeList")
	public String adminDashBoard(Model model) {
	List<Employee> l1=emprepo.findAll();
	model.addAttribute("EmpDetails",l1);
		return "manageEmployees";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam Long id,RedirectAttributes  redirectAttributes)
	{
		emprepo.deleteById(id);
		redirectAttributes.addFlashAttribute("msg","Employee  Deleted");
		return "redirect:/admin/EmployeeList";
	}
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("id") Long id, Model model) {
	    Employee emp = emprepo.findById(id).orElse(null);
	    model.addAttribute("updateUser", emp); 
	    return "update-employee"; //form with employee data
	}
	
	@PostMapping("/update")
	public String updateEmployee(Employee emp, RedirectAttributes redirectAttributes) {
	    try {
	        emprepo.save(emp);
	        redirectAttributes.addFlashAttribute("msg", "Employee updated successfully!");
	        return "redirect:/admin/EmployeeList";
	    } catch (Exception e) {
	        e.printStackTrace();  // Errors
	        redirectAttributes.addFlashAttribute("msg", "Error while updating employee: " + e.getMessage());
	        return "redirect:/admin/EmployeeList";
	    }
	}
}
/*----------------------------------------------------------------*/
	
	
	  