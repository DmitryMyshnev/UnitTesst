package com.homework;

public class Main {
    public static void main(String[] args) {
        Service service = new Shop(new Warehouse());
        System.out.println(service.getTotalPrice("abcd"));
    }
}
