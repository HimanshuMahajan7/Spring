package com.example.binding;

import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {

	private UUID ticketId;
    private String from;
    private String to;
    private String trainNumber;
    private String ticketCost;
    private String ticketStatus;

}
