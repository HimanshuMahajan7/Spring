package org.example.config;

import org.example.beans.Robot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.example", "org.ibm" })
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig :: Constructor");
    }

    @Bean
    public Robot buildRobot() {
        Robot robot = new Robot();
        return robot;
    }
}
