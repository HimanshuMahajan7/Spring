package com.example.controller;

import com.example.exception.CustomerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@GetMapping("/customer/{customerId}")
	public String getCustomer(@PathVariable Integer customerId) throws Exception {
		if (customerId < 100) {
            return "Himanshu";
        } else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
	}
}
