package com.swifties.bahceden.models;

import java.util.ArrayList;
import java.util.Objects;

public class Producer extends User {
    String shopName;
    String backgroundImageURL;
    double rating;

    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBackgroundImageURL() {
        return backgroundImageURL;
    }

    public void setBackgroundImageURL(String backgroundImageURL) {
        this.backgroundImageURL = backgroundImageURL;
    }

    String city; // TODO this is tentative we can change this into a location object etc
    ArrayList<Product> products;
    ArrayList<Order> orders;

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public String getShopName() {
        return shopName;
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
