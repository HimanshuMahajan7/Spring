package org.example;

import org.example.beans.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Starting IoC Container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Getting a bean object from IoC Container
        Car car = context.getBean(Car.class);
        car.drive();
    }
}