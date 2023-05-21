package com.swifties.bahceden.models;

import java.util.ArrayList;

public class Customer extends User {
    Cart cart;
    ArrayList<Product> favoriteProducts;
    ArrayList<Producer> favoriteProducers;
    ArrayList<Order> orders;
    ArrayList<Address> addresses;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setFavoriteProducts(ArrayList<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public void setFavoriteProducers(ArrayList<Producer> favoriteProducers) {
        this.favoriteProducers = favoriteProducers;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public void fillFrom(Customer c) {
        super.fillFrom(c);
        addresses = c.getAddresses();
        cart = c.getCart();
        orders = c.getOrders();
        favoriteProducers = c.getFavoriteProducers();
        favoriteProducts = c.getFavoriteProducts();
    }

    public Cart getCart() {
        return cart;
    }

    public ArrayList<Product> getFavoriteProducts() {
        return favoriteProducts;
    }


    public ArrayList<Producer> getFavoriteProducers() {
        return favoriteProducers;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}
