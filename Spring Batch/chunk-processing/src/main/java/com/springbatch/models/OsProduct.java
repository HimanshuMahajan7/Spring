package com.springbatch.models;

public class OsProduct extends Product {
    private Integer taxPercent;
    private String sku;
    private Integer shippingCost;

    public Integer getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Integer taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "OsProduct[" + ", taxPercent=" + taxPercent + ", sku=" + sku + ", shippingCost=" + shippingCost + "]";
    }
}
