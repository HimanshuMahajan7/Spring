package com.springbatch.processor;

import com.springbatch.models.Product;
import org.springframework.batch.item.ItemProcessor;

public class SimpleProductItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) {
        System.out.println("Processing Item: " + item);
        return item;
    }
}
