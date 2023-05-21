package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Producer extends User {
    private String displayName;
    String city; // TODO this is tentative we can change this into a location object etc
    ArrayList<Product> products;
    ArrayList<Order> orders;

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void fillFrom(Producer p) {
        super.fillFrom(p);
        city = p.getCity();
        displayName = p.getDisplayName();
        orders = p.getOrders();
        products = p.getProducts();
    }
}
