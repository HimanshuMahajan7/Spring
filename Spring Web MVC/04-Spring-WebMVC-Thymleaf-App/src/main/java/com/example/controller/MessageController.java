package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage(Model model) {
		model.addAttribute("msg", "Welcome to Thymeleaf App");
		return "index";
	}
}
