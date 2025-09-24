package com.example.service;

import com.example.request.Passenger;
import com.example.response.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MakeMyTripService {

    @Value("${erail.endpoint.get.ticket}")
    private String ERAIL_GET_TICKET_URL;

    @Value("${erail.endpoint.book.ticket}")
    private String ERAIL_BOOK_TICKET_URL;

    public Ticket getTicket(String ticketId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> ticketResponse = restTemplate.getForEntity(ERAIL_GET_TICKET_URL, Ticket.class, ticketId);
        int statusCodeValue = ticketResponse.getStatusCode().value();
        if (statusCodeValue == 200) {
            return ticketResponse.getBody();
        }
        return null;
    }

    public Ticket getTicketWithWebClient(String ticketId) {
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.get()
                .uri(ERAIL_GET_TICKET_URL, ticketId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();

        return ticket;
    }

    public Ticket bookTicket(Passenger passenger) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> ticketResponse = restTemplate.postForEntity(ERAIL_BOOK_TICKET_URL, passenger, Ticket.class);
        int statusCodeValue = ticketResponse.getStatusCode().value();
        if (statusCodeValue == 200) {
            return ticketResponse.getBody();
        }
        return null;
    }

    public Ticket bookTicketWithWebClient(Passenger passenger) {
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.post()
                .uri(ERAIL_BOOK_TICKET_URL)
                .body(BodyInserters.fromValue(passenger))
                .header("Content-TYpe", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
        return ticket;
    }
}
