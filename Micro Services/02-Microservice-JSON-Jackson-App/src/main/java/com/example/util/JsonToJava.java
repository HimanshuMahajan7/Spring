package com.example.util;

import com.example.binding.Passenger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJava {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Passenger passenger = objectMapper.readValue(new File("./src/main/resources/passenger.json"), Passenger.class);
            System.out.println(passenger);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
