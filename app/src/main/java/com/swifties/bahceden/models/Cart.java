package com.swifties.bahceden.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Order> orders;
    private final int customerId;
    public Cart(int customerId) {
        this.customerId = customerId;
        orders = new ArrayList<>();
    }

    public Order get(int index) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double calculateTotalCost() {
        double totalPrice = 0;
        for (Order o : orders) {
            totalPrice += o.getTotalPrice();
        }
        return totalPrice;
    }

    public boolean addProduct (Product product)
    {
        //Order order = new Order();
        return true;
    }

    public int size() {
        return orders.size();
    }
}
