package com.example.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="13-SpringBoot-Microservices-Greet-API")
public interface GreetFeignClient {
	@GetMapping("/greet")
	public String invokGreetApi();
}
