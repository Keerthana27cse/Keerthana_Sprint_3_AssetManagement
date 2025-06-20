package com.example.assetmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assetmanagement.enums.UserRole;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.model.User;
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
	

	@RequestMapping("/login") // redirected login page
	public String  loginpage(@ModelAttribute ("emp")Employee emp,
			@ModelAttribute("msg")String msg,Model model)
	{
		model.addAttribute("emp",emp);
		model.addAttribute("msg",msg);

		return "login";
	}
	

	
	
	@RequestMapping("/register")  //register page
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
			User user=new User();
			user.setUsername(emp.getUsername());
            user.setEmail(emp.getEmail());
            user.setPassword(emp.getPassword());
            user.setUserrole(UserRole.ROLE_EMPLOYEE);
            userrepo.save(user);
			
			redirectattributes.addFlashAttribute("msg","Registration success.Please Login");
		    redirectattributes.addFlashAttribute("emp",emp);
			return "redirect:/user/login";	
		} catch (Exception e) {
			e.printStackTrace();
            redirectattributes.addFlashAttribute("msg", "Registration failed. Try again.");
            return "redirect:/user/register";
		}
	}
	/*@RequestMapping("logincheck")
	public String register(@RequestParam String email,
	                         @RequestParam String password,
	                         @RequestParam UserRole userrole,
	                         @RequestParam String  username,
	                         RedirectAttributes attributes,
	                         HttpSession session) {
		User user=userrepo.findByEmail(email);
		if (user == null || !user.getPassword().equals(password)) {
            attributes.addFlashAttribute("msg", "Invalid credentials");
            return "redirect:/user/login";
        }

        if (!user.getUsername().equals(username)) {
            attributes.addFlashAttribute("msg", "Invalid credentials");
            return "redirect:/user/login";
        }

        if (user.getUserrole() != userrole) {
            attributes.addFlashAttribute("msg", "Invalid credentials");
            return "redirect:/user/login";
        }	
        session.setAttribute("loggedInUser", user);

        if (userrole == UserRole.ROLE_ADMIN) {
            return "redirect:/admin/dashboard";
        } else if (userrole == UserRole.ROLE_EMPLOYEE) {
            return "redirect:/employee/dashboard";
        }

        attributes.addFlashAttribute("msg", "Invalid credentials");
        return "redirect:/user/login";
    }
	
*/
	
	@RequestMapping("/logincheck")
	public String loginCheck(@RequestParam String email,
	                         @RequestParam String password,
	                         @RequestParam String username,
	                         RedirectAttributes attributes,
	                         HttpSession session) {

	    User user = userrepo.findByEmail(email);
	    if (user == null || !user.getPassword().equals(password)){
	        attributes.addFlashAttribute("msg", "Invalid email or password");
	        return "redirect:/user/login";
	    }
	    if (!user.getUsername().equals(username)) {
	        attributes.addFlashAttribute("msg", "Invalid username");
	        return "redirect:/user/login";
	    }
	    session.setAttribute("loggedInUser", user);
	    if (user.getUserrole() == UserRole.ROLE_ADMIN) {
	        return "redirect:/admin/dashboard";
	    } else if (user.getUserrole() == UserRole.ROLE_EMPLOYEE) {
	        return "redirect:/employee/dashboard";
	    } else {
	        // fallback in case role is something else or null
	        return "redirect:/dashboard";
	    }
	}

		@GetMapping("/logout")
		public String logout(HttpSession session,RedirectAttributes redirectAttributes)
		{
			session.invalidate();
			redirectAttributes.addFlashAttribute("msg","logout successfull");
			return "redirect:/user/";
		}
	}