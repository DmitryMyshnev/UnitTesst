package com.homework.entiry;

import lombok.Data;

@Data
public class Product {
    private String name;
    private Double price;
    private  Long stockCount;
    private  Double stockPrice;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        stockCount = 1L;
        stockPrice = price;
    }

    public Product(String name, Double price, Long stockCount, Double stockPrice) {
        this.name = name;
        this.price = price;
        this.stockCount = stockCount;
        this.stockPrice = stockPrice;
    }
}
