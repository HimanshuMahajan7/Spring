package com.example.controller;

import com.example.request.Passenger;
import com.example.response.Ticket;
import com.example.service.MakeMyTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakeMyTripController {

    @Autowired
    MakeMyTripService makeMyTripService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(Passenger passenger, Model model) {
        System.out.println(passenger);
        Ticket ticket = makeMyTripService.bookTicketWithWebClient(passenger);
        model.addAttribute("ticket", ticket);
        return "success";
    }

    @GetMapping("search")
    public String search() {
        return "search";
    }

    @GetMapping("searchTicket")
    public String searchTicket(@RequestParam("ticketId") String ticketId, Model model) {
        System.out.println("Ticket Id: " + ticketId);
        Ticket ticket = makeMyTripService.getTicketWithWebClient(ticketId);
        model.addAttribute("ticket", ticket);
        return "search";
    }
}
