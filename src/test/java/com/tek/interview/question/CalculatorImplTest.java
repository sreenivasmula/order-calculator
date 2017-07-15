package com.tek.interview.question;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorImplTest {
    
    private Item item;

    private OrderLine orderLine;
    
    private Order order;   
    
    private Calculator calculator;
    
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        item = new Item("book", (float) 12.49);
        orderLine = new OrderLine(item, 1);
        order = new Order();        
        calculator = new CalculatorImpl();    
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setCalculator() throws Exception {
        
        order.add(orderLine);
        Map<String, Order> orders = new LinkedHashMap<String, Order>();
        orders.put("Order 1", order);
        calculator.calculate(orders);
        Assert.assertEquals(rounding(order.get(0).getItem().getPrice()), 12.49, DELTA);        
    }
    
    private double rounding(double value) {
        value = Math.round(value * 100);
        return value = value / 100;
    }
}