package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageController {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome to Atom dot com";
	}
}
