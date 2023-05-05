package com.swifties.bahceden.models;

import java.util.Set;

public class Customer extends User {
    Cart cart;
    Set<Product> favoriteProducts;
    Set<Producer> favoriteProducers;
    Set<Order> orders;
    Set<Address> addresses;

    public Cart getCart() {
        return cart;
    }

    public Set<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public Set<Producer> getFavoriteProducers() {
        return favoriteProducers;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addItemToCart() {

    }

    public void removeItemFromCart() {

    }
}
