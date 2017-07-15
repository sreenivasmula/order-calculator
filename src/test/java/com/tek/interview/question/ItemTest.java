package com.tek.interview.question;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemTest {

    private Item item;

    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        item = new Item("book", (float) 12.49);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testItem() {
        Assert.assertEquals(item.getDescription(), "book");
        Assert.assertEquals(item.getPrice(), (float) 12.49, DELTA);
    }
}


