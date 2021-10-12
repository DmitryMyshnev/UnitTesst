package com.homework;

import com.homework.entiry.Product;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Character,Product> warehouse;

    public Warehouse() {
        warehouse = new HashMap<>();
        warehouse.put('A',new Product("A",1.25,2L,1.00));
        warehouse.put('B',new Product("B",4.25));
        warehouse.put('C',new Product("C",1.00,3L,0.95));
        warehouse.put('D',new Product("D",0.75));
    }

    public Product getProductByKey(Character key){
       if(warehouse.containsKey(key)){
           return warehouse.get(key);
       }else {
           return null;
       }
    }
}
