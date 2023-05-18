package com.swifties.bahceden.models;

import java.util.ArrayList;

public class Cart implements Retrievable<Cart> {
    private ArrayList<Order> orders;
    private int id;

    public Cart(int id) {
        this.id = id;
        orders = new ArrayList<>();
    }

    public Order get(int index) {
        return orders.get(index);
    }

    public Order get(int index, PostAction postAction) {
        orders.get(index).getProduct().retrieveFromDB(postAction);
        return orders.get(index);
    }

    public Order getById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public boolean remove(int index) {
        return orders.remove(index) != null;
        //TODO sync with db
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void fillFrom(Cart obj) {

    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public double calculateTotalCost() {
        double totalPrice = 0;
        for (Order o : orders) {
            totalPrice += o.getTotalPrice();
        }
        return totalPrice;
    }

    public int size() {
        return orders.size();
    }
}
