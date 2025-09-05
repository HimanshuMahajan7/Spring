package com.example;

import com.example.util.PasswordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		String iocContainerClass = context.getClass().getName();
		System.out.println(iocContainerClass);
	}

	@Bean
	public PasswordUtils getPasswordUtils() {
		return new PasswordUtils();
	}
}
