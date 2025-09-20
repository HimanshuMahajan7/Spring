package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage(Model model) {
		model.addAttribute("msg", "Welcome to Model View");
		return "index";
	}
	
	@GetMapping("/greet")
	@ResponseBody
	public String greetMessage() {
		return "Welcome to Direct Message";
	}
}
