package org.example;

public class Motor {
    public Motor() {
        System.out.println("Motor :: Constructor");
    }

    public void start() {
        System.out.println("Motor Started...");
    }

    public void doWork() {
        System.out.println("Motor Pulling Water...");
    }

    public void stop() {
        System.out.println("Motor Stopped...");
    }
}
