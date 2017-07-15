package com.tek.interview.question;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
    
    private Item item;

    private OrderLine orderLine;
    
    private Order order;    

    @Before
    public void setUp() throws Exception {
        item = new Item("book", (float) 12.49);
        orderLine = new OrderLine(item, 1);
        order = new Order();  
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testOrder() throws Exception {
        
        order.add(orderLine);
        Assert.assertEquals(order.size(), 1);
        Assert.assertNotNull(order.get(0));
    }
    
    @Test(expected = Exception.class)
    public void testOrderWithException() throws Exception {
        
        order.add(null);        
    }
}
