package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
public class Customer extends User {
    Cart cart;
    ArrayList<Product> favoriteProducts;
    ArrayList<Producer> favoriteProducers;
    ArrayList<Order> orders;
    ArrayList<Address> addresses;

    public Customer(int id) {
        super(id);
    }

    public Customer(int id, String name, String email, String password, String phoneNumber, Cart cart, ArrayList<Product> favoriteProducts, ArrayList<Producer> favoriteProducers, ArrayList<Order> orders, ArrayList<Address> addresses) {
        super(id, name, email, password, phoneNumber);
        this.cart = cart;
        this.favoriteProducts = favoriteProducts;
        this.favoriteProducers = favoriteProducers;
        this.orders = orders;
        this.addresses = addresses;
    }

    public void fillFrom(Customer c)
    {
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
