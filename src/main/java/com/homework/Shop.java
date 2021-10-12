package com.homework;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop implements Service {
    private final Warehouse warehouse;
    private Double total = 0.0;

    public Shop(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public Double getTotalPrice(String products) {
        if (products == null) {
            return 0.0;
        }
        total = 0.0;
        char[] charOfProduct = products.toUpperCase().toCharArray();
        List<Character> charEquals = IntStream.range(0, charOfProduct.length).mapToObj(i -> charOfProduct[i]).collect(Collectors.toList());
        IntStream.range(0, charOfProduct.length).mapToObj(i -> charOfProduct[i]).forEach(c -> {
            if (warehouse.getProductByKey(c) != null) {
                Long stockCount = warehouse.getProductByKey(c).getStockCount();
                long charEqualsCount = charEquals.stream().filter(f -> (f.equals(c))).count();
                if (charEqualsCount >= stockCount) {
                    total += warehouse.getProductByKey(c).getStockPrice();
                } else {
                    total += warehouse.getProductByKey(c).getPrice();
                }
            }
        });
        return total;
    }
}
