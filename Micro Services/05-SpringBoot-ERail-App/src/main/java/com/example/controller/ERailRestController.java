package com.example.controller;

import com.example.binding.Passenger;
import com.example.binding.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ERailRestController {

    Map<UUID, Ticket> ticketMap = new HashMap<>();

    @Operation(summary = "Book Ticket", description = "Book a Train Ticket")
    @ApiResponse(responseCode = "200", description = "Ticket Booked")
    @PostMapping(
        value = "/ticket",
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"}
    )
    public Ticket bookTicket(@RequestBody Passenger passenger) {
        UUID ticketNumber = UUID.randomUUID();
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketNumber);
        ticket.setFrom("Bangalore");
        ticket.setTo("Indore");
        ticket.setTrainNumber("1234");
        ticket.setTicketCost("1500.00");
        ticket.setTicketStatus("Booked");

        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    @GetMapping(
            value = "ticket/{ticketNumber}",
            produces = {"application/json"}
    )
    public Ticket getTicket(@PathVariable String ticketNumber) {
        UUID ticketId = UUID.fromString(ticketNumber);
        return ticketMap.get(ticketId);
    }
}
