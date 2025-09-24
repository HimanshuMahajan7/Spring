package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        Info info = new Info();
        info.title("MakeMyTrip Service API")
                .version("v1")
                .description("REST API documentation for MakeMyTrip Service");
        return new OpenAPI().info(info);
    }

}
