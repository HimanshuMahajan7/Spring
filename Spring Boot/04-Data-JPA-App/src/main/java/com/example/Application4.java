package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application4 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application4.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository.getClass().getName());

        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.forEach(System.out::println);
    }
}
