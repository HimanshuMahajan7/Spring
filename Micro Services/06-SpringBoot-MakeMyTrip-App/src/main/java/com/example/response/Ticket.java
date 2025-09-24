package com.example.response;

import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {

	private UUID ticketId;
    private String passengerName;
    private String from;
    private String to;
    private String doj;
    private String trainNumber;
    private String ticketCost;
    private String ticketStatus;

}
