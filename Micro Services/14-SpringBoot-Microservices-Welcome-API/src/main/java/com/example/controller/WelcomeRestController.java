package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetFeignClient greetClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String welcomeMsg = "Welcome !!!";
		String greetMsg = greetClient.invokGreetApi();
		return welcomeMsg + " " + greetMsg;
	}
}
