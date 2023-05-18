package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Producer extends User {
    private String displayName;
    String city; // TODO this is tentative we can change this into a location object etc
    ArrayList<Product> products;
    ArrayList<Order> orders;

    public Producer(int id) {
        super(id);
    }

    public Producer(int id, String name, String email, String password, String phoneNumber, String displayName, String city, ArrayList<Product> products, ArrayList<Order> orders) {
        super(id, name, email, password, phoneNumber);
        this.displayName = displayName;
        this.city = city;
        this.products = products;
        this.orders = orders;
    }

    @NonNull
    @Override
    public String toString() {
        //TODO
        return "TODO";
//        return "{" +
//                " \"user\": " + super.toString() + "," +
//                " \"displayName\": \"" + displayName + "\"," +
//                " \"city\": \"" + city + "\"," +
//                " \"productIds\": " + productIds.toString() + "," +
//                " \"orderIds\":" + orderIds.toString() +
//                '}';
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
