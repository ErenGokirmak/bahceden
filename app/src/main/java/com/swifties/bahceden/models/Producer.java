package com.swifties.bahceden.models;

import java.util.Set;

public class Producer extends User {
    Set<Product> products;
    Set<Order> orders;
    String city; // this is tentative we can change this into a location object etc
    private String displayName;

    public Producer(Set<Product> products, Set<Order> orders, String city, String displayName) {
        this.products = products;
        this.orders = orders;
        this.city = city;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public String getCity() {
        return city;
    }

}
