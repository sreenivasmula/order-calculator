package com.tek.interview.question;

import java.util.Map;
import java.util.regex.Pattern;

public class CalculatorImpl implements Calculator {
    
    private static final String IMPORTED = "imported";
    
    private double rounding(double value) {
        double roundedValue = Math.round(value * 100);
        return roundedValue / 100;
    }

    /**
     * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
     * is the item's price * quantity * taxes.
     * 
     * For each order, print the total Sales Tax paid and Total price without taxes for this order
     */
    public void calculate(Map<String, Order> o) {

        double grandtotal = 0;

        // Iterate through the orders
        for (Map.Entry<String, Order> entry : o.entrySet()) {
            System.out.println("*******" + entry.getKey() + "*******");

            Order r = entry.getValue();

            double totalTax = 0;
            double total = 0;

            // Iterate through the items in the order
            for (int i = 0; i < r.size(); i++) {

                // Calculate the taxes
                double tax = 0;
                
                
                String description = r.get(i).getItem().getDescription();
                float price = r.get(i).getItem().getPrice();
                int quantity = r.get(i).getQuantity();

                
                if (isImported(description)) {
                    tax = rounding(price * 0.15); // Extra 5% tax on imported items
                } else {
                    tax = rounding(price * 0.10);
                }

                // Calculate the total price
                double totalprice = price + tax;

                // Print out the item's total price
                System.out.println(quantity + " " + description + ": " + rounding(totalprice));

                // Keep a running total
                totalTax += tax * quantity;
                total += price * quantity;
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + rounding(totalTax));

            // Print out the total amount
            System.out.println("Total: " + rounding(total));
            grandtotal += total;
        }

        System.out.println("Sum of orders: " + rounding(grandtotal));
    }
    
    private boolean isImported(String description) {
        return Pattern.compile(Pattern.quote(IMPORTED), Pattern.CASE_INSENSITIVE).matcher(description).find();
        //if (description.toLowerCase().contains("imported")) {
    }

}