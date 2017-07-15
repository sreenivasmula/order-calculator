package com.tek.interview.question;

/*
 * represents an order line which contains the @link Item and the quantity.
 *
 */
class OrderLine {

    private int quantity;
    private Item item;

    /*
     * @param item Item of the order
     * 
     * @param quantity Quantity of the item
     */
    public OrderLine(Item item, int quantity) {
        
        if (item == null) {
            System.err.println("ERROR - Item is NULL");
            throw new IllegalArgumentException("Item is NULL");
        }
        if(quantity < 1) {
            System.err.println("ERROR - Quantity is less than 1 ");
            throw new IllegalArgumentException("Quantity is less than 1");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
