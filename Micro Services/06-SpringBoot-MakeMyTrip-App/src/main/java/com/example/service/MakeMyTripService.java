package com.example.service;

import com.example.request.Passenger;
import com.example.response.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MakeMyTripService {

    private static final String ERAIL_URL = "http://localhost:8080/ticket";

    public Ticket bookTicket(Passenger passenger) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> ticketResponse = restTemplate.postForEntity(ERAIL_URL, passenger, Ticket.class);
        int statusCodeValue = ticketResponse.getStatusCode().value();
        if (statusCodeValue == 200) {
            return ticketResponse.getBody();
        }
        return null;
    }
}
