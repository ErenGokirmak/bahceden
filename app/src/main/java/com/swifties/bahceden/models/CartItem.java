package com.swifties.bahceden.models;

public class CartItem {
    private Product product;
    private int amount;
    private double totalPrice;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    private void calculateTotalPrice ()
    {
        totalPrice = amount * product.getPricePerUnit();
    }

    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void increseAmountBy (int increment)
    {
        amount += increment;
    }
}
