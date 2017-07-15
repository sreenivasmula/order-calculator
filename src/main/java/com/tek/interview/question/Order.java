package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public void add(OrderLine o) {
        if (o == null) {
            System.err.println("ERROR - Order is NULL");
            throw new IllegalArgumentException("Order is NULL");
        } 
        orderLines.add(o);      
    }

    public int size() {
        return orderLines.size();
    }

    public OrderLine get(int i) {
        return orderLines.get(i);
    }   
}


/*
 * Copyright 2017 Capital One Financial Corporation All Rights Reserved.
 * 
 * This software contains valuable trade secrets and proprietary information of
 * Capital One and is protected by law. It may not be copied or distributed in
 * any form or medium, disclosed to third parties, reverse engineered or used in
 * any manner without prior written authorization from Capital One.
 */
