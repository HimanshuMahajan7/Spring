package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application2 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application2.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Product product = new Product();
        product.setProductName("Motherboard");
        product.setProductPrice(102.00);
        productRepository.save(product);

        System.out.println("\n\n");
    }
}
