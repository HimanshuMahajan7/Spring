package com.example.util;

import com.example.binding.Address;
import com.example.binding.Passenger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JavaToJson {
    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("Indore");
        address.setState("Madhya Pradesh");
        address.setCountry("India");

        Passenger passenger = new Passenger();
        passenger.setName("Himanshu");
        passenger.setGender("Male");
        passenger.setFrom("Bangalore");
        passenger.setTo("Indore");
        passenger.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File("./src/main/resources/passenger.json"), passenger);
            String passengerJson = objectMapper.writeValueAsString(passenger);
            System.out.println(passenger);
            System.out.println(passengerJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
