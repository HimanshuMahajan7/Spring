package com.springbatch.processor.transformer;

import com.springbatch.models.OsProduct;
import com.springbatch.models.Product;
import org.springframework.batch.item.ItemProcessor;

public class ComplexProductItemTransformer implements ItemProcessor<Product, OsProduct> {
    @Override
    public OsProduct process(Product item) {
        System.out.println("Processing & Transforming Item: " + item);
        OsProduct osProduct = new OsProduct();
        osProduct.setProductId(item.getProductId());
        osProduct.setProductName(item.getProductName());
        osProduct.setProductCategory(item.getProductCategory());
        osProduct.setProductPrice(item.getProductPrice());
        osProduct.setTaxPercent(item.getProductCategory().equals("Sports Accessories") ? 5 : 18);
        osProduct.setSku(item.getProductCategory().substring(0, 3) + "_" + item.getProductId());
        osProduct.setShippingCost(item.getProductPrice() < 1000 ? 75 : 0);
        return osProduct;
    }
}
