package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class DemoController {

	@GetMapping("/demo-null-error")
	public String getNullPointerExceptionDemo() {
		String str = null;
		int len = str.length();
		return "Demo controller called!!!";
	}
	
	@GetMapping("/demo-cusom-error")
	public String getCustomException() throws Exception {
		if(true) {
			throw new Exception("Custom Exception from demo custom error!!!");
		}
		return "Demo controller called!!!";
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView arithmeticError(NullPointerException ex) {
		System.out.println("DemoController >> /demo-null-error >> NullPointerException Occurred");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", ex.getMessage());
		modelAndView.setViewName("null-error");
		return modelAndView;
	}
}
