package com.example.controller;

import com.example.binding.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @GetMapping("customer")
    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName("Himanshu");
        customer.setGender("Male");
        customer.setEmail("emailofhim@gmail.com");
        return customer;
    }
}
