package com.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service service = new Shop(new Warehouse());
        String card = "cccccccccc";
        System.out.println( service.getTotalPrice(card));

    }
}
