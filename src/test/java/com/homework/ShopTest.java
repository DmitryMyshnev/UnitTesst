package com.homework;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

public class ShopTest {
    private static Service shop;
    private static Service mock;

    @BeforeClass
    public static void init() {
        shop = new Shop(new Warehouse());
        mock = Mockito.spy(shop);
        Mockito.when(mock.getTotalPrice("")).thenReturn(0.0);
        Mockito.when(mock.getTotalPrice(null)).thenReturn(0.0);
        Mockito.when(mock.getTotalPrice("ABCD")).thenReturn(7.25);
        Mockito.when(mock.getTotalPrice("abcd")).thenReturn(7.25);
        Mockito.when(mock.getTotalPrice("A12BCD")).thenReturn(7.25);
        Mockito.when(mock.getTotalPrice("ABcd")).thenReturn(7.25);
        Mockito.when(mock.getTotalPrice("123")).thenReturn(0.0);
        Mockito.when(mock.getTotalPrice("AAA")).thenReturn(3.0);
        Mockito.when(mock.getTotalPrice("A")).thenReturn(1.25);
    }

    @Test
    public void getTotalPriceWithEmptyCard() {
        Double res = shop.getTotalPrice("");
        Assert.assertEquals("It is not true ", 0.0, res, 0.0);
    }

    @Test
    public void getTotalPriceWithNullArg() {
        Double res = shop.getTotalPrice(null);
        Assert.assertEquals("It is not true ", 0.0, res, 0.0);
    }

    @Test
    public void getTotalPriceWithNormalArg() {
        Double res = shop.getTotalPrice("ABCD");
        Assert.assertEquals("It is not true ", 7.25, res, 0.0);
    }

    @Test
    public void getTotalPriceWithLowerCaseArg() {
        Double res = shop.getTotalPrice("abcd");
        Assert.assertEquals("It is not true ", 7.25, res, 0.0);
    }

    @Test
    public void getTotalPriceIfHasDigitArg() {
        Double res = shop.getTotalPrice("A12BCD");
        Assert.assertEquals("It is not true ", 7.25, res, 0.0);
    }

    @Test
    public void getTotalPriceWithMultiLowerAndUpperCaseArg() {
        Double res = shop.getTotalPrice("ABcd");
        Assert.assertEquals("It is not true ", 7.25, res, 0.0);
    }

    @Test
    public void getTotalPriceWithOnlyDigit() {
        Double res = shop.getTotalPrice("123");
        Assert.assertEquals("It is not true ", 0.0, res, 0.0);
    }

    @Test
    public void getTotalPriceAtSpecialPrice() {
        Double res = shop.getTotalPrice("AAA");
        Assert.assertEquals("It is not true ", 3.0, res, 0.0);
    }

    @Test
    public void getTotalPriceAtUsualPrice() {
        Double res = shop.getTotalPrice("A");
        Assert.assertEquals("It is not true ", 1.25, res, 0.0);
    }

}