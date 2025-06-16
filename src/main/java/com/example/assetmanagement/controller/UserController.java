package com.example.assetmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.User;
import com.example.assetmanagement.model.UserRole;
import com.example.assetmanagement.repository.EmployeeRepo;
import com.example.assetmanagement.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userrepo;
	@Autowired
	private EmployeeRepo emprepo; 
	
	@GetMapping("/")
	public String showloginpage()// first loads login
	{
		return "login";
	}
	
	@GetMapping ("/register")// click loads register
	public String  showregisterpage() 
	{
		return "register";	
	}
	
	

	
	@RequestMapping("register")  //register page
	public String register(Employee emp,RedirectAttributes redirectattributes)
	{
		try {
			Employee existingemp=emprepo.findByEmail(emp.getEmail());
			if(existingemp!=null)
			{
				redirectattributes.addFlashAttribute("msg","Email already registered ...please login");
			    redirectattributes.addFlashAttribute("emp",emp);
				return "redirect:/user/login";
			}
			emprepo.save(emp);
			redirectattributes.addFlashAttribute("msg","Registration success");
		    redirectattributes.addFlashAttribute("emp",emp);
			return "redirect:/user/login";	
		} catch (Exception e) {
			e.printStackTrace();
            redirectattributes.addFlashAttribute("msg", "Registration failed. Try again.");
            return "redirect:/user/register";
		}
		
	}
	
	
	@RequestMapping("/login") // redirected login page
	public String  loginpage(@ModelAttribute ("emp")Employee emp,
			@ModelAttribute("msg")String msg,Model model)
	{
		model.addAttribute("emp",emp);
		model.addAttribute("msg",msg);
		return "login";
	}
	

	@RequestMapping("logincheck")
	public String register(@RequestParam String email,
	                         @RequestParam String password,
	                         RedirectAttributes attributes,
	                         HttpSession session) {
	    //admin
		
		User u1 = userrepo.findByEmail(email);
	    if (u1 != null) {
	        if (u1.getPassword().equals(password)) {
	            session.setAttribute("loggedInUser", u1);
	            if (u1.getRole()==UserRole.ADMIN) {
	                return "redirect:/admin/dashboard";
	            } else {
	                attributes.addFlashAttribute("msg", "Unauthorized role in User table");
	                return "redirect:/user/login";
	            }
	        } else {
	            attributes.addFlashAttribute("msg", "Invalid password");
	            return "redirect:/user/login";
	        }
	    }
	   
	    //employee
	    Employee emp = emprepo.findByEmail(email);
	    if (emp != null) {
	        if (emp.getPassword().equals(password)) {
	            session.setAttribute("loggedInUser", emp);
	                return "redirect:/employee/dashboard";
	        } 
	        }else {
	            attributes.addFlashAttribute("msg", "Invalid password");
	            return "redirect:/user/login";
	        }
	        
	    attributes.addFlashAttribute("msg", "Invalid email or password");
	    return "redirect:/user/login";
	}
		
	
		
		@GetMapping("/logout")
		public String logout(HttpSession session,RedirectAttributes redirectAttributes)
		{
			session.invalidate();
			redirectAttributes.addFlashAttribute("msg","logout successfull");
			return "redirect:/";
		}
		
	}