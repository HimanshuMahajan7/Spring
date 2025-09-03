package org.example;

import org.example.beans.Motor;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Motor motor1 = context.getBean(Motor.class);
        System.out.println(motor1.hashCode());

        Motor motor2 = context.getBean(Motor.class);
        System.out.println(motor2.hashCode());
    }
}