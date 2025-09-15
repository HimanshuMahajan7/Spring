package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        System.out.println("Car :: Constructor");
    }
}
