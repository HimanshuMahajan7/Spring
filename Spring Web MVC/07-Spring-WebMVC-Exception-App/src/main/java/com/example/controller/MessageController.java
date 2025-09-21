package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class MessageController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		int error = 10/0;
		return "Welcome to Atom.com";
	}
	
	@GetMapping("/greet")
	public String getGreetMessage() throws Exception {
		if(true) {
			throw new Exception("Custom Exception from greet!!!");
		}
		return "Good Morning @ Atom.com";
	}

	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView arithmeticError(ArithmeticException ex) {
		System.out.println("MessageController >> /welcome >> ArithmeticException Occurred");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", ex.getMessage());
		modelAndView.setViewName("arithmetic-error");
		return modelAndView;
	}
}
