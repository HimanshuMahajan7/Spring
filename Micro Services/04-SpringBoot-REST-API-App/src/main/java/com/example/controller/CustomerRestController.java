package com.example.controller;

import com.example.binding.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

    @GetMapping(
            value = "/customer",
            produces = {"application/xml", "application/json"}
    )
    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName("Himanshu");
        customer.setGender("Male");
        customer.setEmail("emailofhim@gmail.com");
        return customer;
    }

    @PostMapping(
            value = "/customer",
            consumes = {"application/xml", "application/json"},
            produces = {"text/plain"}
    )
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        System.out.println("Customer: " + customer);
        String msg = "Customer Saved!";
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
