package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

    public MsgRestController() {
        System.out.println("\nMsgRestController :: No Param Constructor\n");
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcomeMsg() {
        String msg = "Welcome!!!";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/greet")
    public String greetMsg() {
        String msg = "Good Morning!!!";
        return msg;
    }
}
