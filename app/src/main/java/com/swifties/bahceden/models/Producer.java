package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Producer extends User {
    private String displayName;
    String city; // this is tentative we can change this into a location object etc
    ArrayList<Integer> productIds;
    ArrayList<Integer> orderIds;

    public Producer(int id) {
        super(id);
    }

    public String getDisplayName() {
        return displayName;
    }

    public ArrayList<Integer> getOrderIds() {
        return orderIds;
    }

    public ArrayList<Integer> getProductIds() {
        return productIds;
    }

    public String getCity() {
        return city;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" +
                " \"user\": " + super.toString() + "," +
                " \"displayName\": \"" + displayName + "\"," +
                " \"city\": \"" + city + "\"," +
                " \"productIds\": " + productIds.toString() + "," +
                " \"orderIds\":" + orderIds.toString() +
                '}';
    }
}
