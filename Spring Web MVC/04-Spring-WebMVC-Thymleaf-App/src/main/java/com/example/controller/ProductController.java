package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.Product;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@PostMapping("/product")
	public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
		System.out.println("Product: " + product);
		if(bindingResult.hasErrors()) {
			return "index";
		} else {
			model.addAttribute("msg", "Product Saved!!!");
		}
		return "index";
	}
}
