package com.homework;

import com.homework.entiry.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<Character,Long> mapUnique = new HashMap<>();
        total = 0.0;
        char[] charOfProduct = products.toUpperCase().toCharArray();
        List<Character> charEquals = IntStream.range(0, charOfProduct.length).mapToObj(i -> charOfProduct[i]).collect(Collectors.toList());
        IntStream.range(0, charOfProduct.length).mapToObj(i -> charOfProduct[i]).forEach(c -> {
            if (warehouse.getProductByKey(c) != null) {
                Long charEqualsCount = charEquals.stream().filter(f -> (f.equals(c))).count();
                mapUnique.put(c,charEqualsCount);
            }
        });
        mapUnique.forEach((ch, count) -> {
            Product prod = warehouse.getProductByKey(ch);
            if(count % prod.getStockCount() == 0){
                total += (count / prod.getStockCount()) * prod.getStockPrice();
            }else {
                long t = count / prod.getStockCount();
                long diff = count - t * prod.getStockCount();
                total += (t * prod.getStockPrice()) + (diff * prod.getPrice());
            }
        });
        return total;
    }
}
