package com.springbatch.processor.filter;

import com.springbatch.models.Product;
import org.springframework.batch.item.ItemProcessor;

public class FilterItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) {
        if (item.getProductPrice() > 100) {
            return item;
        }
        return null;
    }
}
