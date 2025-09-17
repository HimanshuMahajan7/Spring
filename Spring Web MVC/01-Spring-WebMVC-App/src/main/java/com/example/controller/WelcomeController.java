package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/car/{carId}")
    public ModelAndView getCarColor(@PathVariable Integer carId) {
        ModelAndView modelAndView = new ModelAndView();
        String color = null;
        color = carId >= 100 ? "Black" : "Red";
        String msg = "Car color is: " + color;
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
