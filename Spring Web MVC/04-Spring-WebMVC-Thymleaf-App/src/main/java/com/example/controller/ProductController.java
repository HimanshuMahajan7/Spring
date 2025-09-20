package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.Product;

@Controller
public class ProductController {

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@PostMapping("/product")
	public String saveProduct(Product product, Model model) {
		System.out.println("Product: " + product);
		model.addAttribute("msg", "Product Saved!!!");
		return "index";
	}
}
