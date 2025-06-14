package com.springbatch.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductItemPreparedStatementSetter implements org.springframework.batch.item.database.ItemPreparedStatementSetter<Product> {
    @Override
    public void setValues(Product item, PreparedStatement ps) throws SQLException {
        ps.setInt(1, item.getProductId());
        ps.setString(2, item.getProductName());
        ps.setString(3, item.getProductCategory());
        ps.setInt(4, item.getProductPrice());
    }
}
