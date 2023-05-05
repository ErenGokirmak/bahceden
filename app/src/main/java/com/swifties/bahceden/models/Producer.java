package com.swifties.bahceden.models;

import java.util.Set;

public class Producer extends User {
    Set<Product> products;
    Set<Order> orders;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
