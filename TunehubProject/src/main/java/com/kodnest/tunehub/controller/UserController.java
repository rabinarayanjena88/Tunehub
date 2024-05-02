package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	 @Autowired
	    private UserService userService;

	
	 @PostMapping("/register")
	 
	 public String userRegistration(@ModelAttribute User user) {
	     User existingUser = userService.emailExists(user);
	     if (existingUser == null) {
	         userService.addUser(user);
	         System.out.println("User added successfully");
	         System.out.println(user);
	     } else {
	         System.out.println("Duplicate user with the same email exists");
	         // Handle duplicate user scenario (e.g., show error message to user)
	     }
	     return "redirect:/login";

	 }
	 
	 
	 //..................
	 
	 @PostMapping("/validate")
	 public String userValidate(@RequestParam("email") String email , @RequestParam("password") String password,HttpSession session) {
		 
		 System.out.println(email + "_" + password +" -login");
		 // Retrieve the user by email
	        User user = userService.emailExists(email);

	        if (user != null && user.getPassword().equals(password)) {
	        	
	        	session.setAttribute("email", email);
	        	
	            String role = user.getRole();
	            if ("admin".equals(role)) {
	                return "redirect:adminhome";
	            } else if ("customer".equals(role)) {
	                return "redirect:customerhome";
	            } else {
	                // Handle other roles or scenarios
	                return "redirect:/";
	            }
	        } else {
	            return "redirect:/login?error";
	        }
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "login";
	 }

}
