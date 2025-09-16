package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public ModelAndView getWelcomeMessage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "Welcome");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Himanshu ");
        return "hello";
    }
}
