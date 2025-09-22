package com.example.util;

import com.example.binding.Passenger;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonToJava {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            Passenger passenger = gson.fromJson(new FileReader("./src/main/resources/passenger.json"), Passenger.class);
            System.out.println(passenger);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
