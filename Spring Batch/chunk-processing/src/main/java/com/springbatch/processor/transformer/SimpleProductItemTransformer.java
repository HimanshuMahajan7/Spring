package com.springbatch.processor.transformer;

import com.springbatch.models.Product;
import org.springframework.batch.item.ItemProcessor;

public class SimpleProductItemTransformer implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) {
        System.out.println("Processing Item: " + item);
        Integer price = item.getProductPrice();
        item.setProductPrice((int) (price - (0.1 * price)));
        return item;
    }
}
