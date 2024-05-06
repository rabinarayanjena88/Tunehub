package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodnest.tunehub.service.SongService;

@Controller
public class NavController {
	@Autowired
	SongService songService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	@GetMapping("/song")
	public String song() {
		return "song";
	}
	//.................
	 @GetMapping("adminhome")
	    public String adminhome() {
	        return "adminhome";
	    }
	 @GetMapping("customerhome")
	    public String customerhome() {
	        return "customerhome";
	    }
	 
	
}
