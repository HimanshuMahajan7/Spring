package com.springbatch.models;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

    @Override
    public Product mapFieldSet(FieldSet fieldSet) {
        Product product = new Product();
        product.setProductId(fieldSet.readInt("product_id"));
        product.setProductName(fieldSet.readString("product_name"));
        product.setProductCategory(fieldSet.readString("product_category"));
        product.setProductPrice(fieldSet.readInt("product_price"));
        return product;
    }
}
