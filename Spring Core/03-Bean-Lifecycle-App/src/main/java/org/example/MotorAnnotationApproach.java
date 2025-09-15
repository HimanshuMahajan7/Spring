package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MotorAnnotationApproach {
    public MotorAnnotationApproach() {
        System.out.println("MotorAnnotationApproach :: Constructor");
    }

    public void doWork() {
        System.out.println("MotorAnnotationApproach Pulling Water...");
    }

    @PostConstruct
    public void m1() {
        System.out.println("MotorAnnotationApproach Started...");
    }

    @PreDestroy
    public void m2() {
        System.out.println("MotorAnnotationApproach Stopped...");
    }
}
