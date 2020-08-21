package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techleads.app.model.User;
import com.techleads.app.service.RegisterService;

@Controller
public class LoginController {
	@Autowired
	private RegisterService registerService;
	
	@GetMapping(value = "/login")
	public String login(@ModelAttribute User user,Model model) {
		model.addAttribute("user", new User());
		
		return "login";
		//return "redirect:/ui/";
	}
	
	@PostMapping(value = "/login")
	public String login1(@ModelAttribute User user,Model model) {
		model.addAttribute("user", new User());
		
		User findByUsername = registerService.findByUsername(user.getUsername());
		if(findByUsername.getId()==0) {
			return "login";
		}
		//return "login";
		return "redirect:/ui/";
	}
	
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute User user, Model model) {
		registerService.registerUser(user);
		return "redirect:/login";
	}
	
	@GetMapping(value = "/ui")
	public String uiPage(Model model) {
		model.addAttribute("msg", "you are logged in");
		return "uipage";
	}

}
