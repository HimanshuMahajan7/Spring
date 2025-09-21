package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleGlobalException(Exception ex, WebRequest request) {
		System.out.println("GlobalExceptionHandler >> Exception Occurred");
		System.out.println("Handling exception at: " + request.getDescription(false));
	    ex.printStackTrace();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", ex.getMessage());
		modelAndView.setViewName("global-error");
		return modelAndView;
	}
}
