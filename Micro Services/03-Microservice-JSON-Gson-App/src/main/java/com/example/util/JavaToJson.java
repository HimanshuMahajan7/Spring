package com.example.util;

import com.example.binding.Address;
import com.example.binding.Passenger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String passengerJson = gson.toJson(passenger);

        System.out.println(passenger);
        System.out.println(passengerJson);
    }
}
