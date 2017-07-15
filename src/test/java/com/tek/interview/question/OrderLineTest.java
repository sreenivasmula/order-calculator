package com.tek.interview.question;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderLineTest {

    private Item item;

    private OrderLine orderLine;

    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        item = new Item("book", (float) 12.49);
        orderLine = new OrderLine(item, 1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testOrderLine() {
        Assert.assertNotNull(orderLine.getItem());
        Assert.assertEquals(item.getDescription(), "book");
        Assert.assertEquals(item.getPrice(), (float) 12.49, DELTA);
        Assert.assertEquals(orderLine.getQuantity(), 1);
    }
    
    @Test(expected=Exception.class)
    public void testOrderLineWithZeroQuantity() throws Exception {
        
        orderLine = new OrderLine(item, 0);
    }
    
    @Test(expected=Exception.class)
    public void testOrderLineWithException() throws Exception {
        
        item = null;
        orderLine = new OrderLine(item, 1);
    }
}