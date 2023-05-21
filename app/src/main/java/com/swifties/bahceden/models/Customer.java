package com.swifties.bahceden.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer extends User {
    Cart cart;
    List<Product> favoriteProducts;
    List<Producer> favoriteProducers;
    List<Order> orders;
    List<Address> addresses;

    public Customer() {
        favoriteProducts = new ArrayList<>();
        favoriteProducers = new ArrayList<>();
        orders = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setFavoriteProducts(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public void setFavoriteProducers(List<Producer> favoriteProducers) {
        this.favoriteProducers = favoriteProducers;
    }


    public void setOrders(List<Order> orders) {
        this.orders = orders;
        this.cart = new Cart(getId());
        this.cart.setOrders(orders.stream().filter(order -> order.getOrderStatus() == Order.OrderStatus.IN_CART).collect(Collectors.toList()));
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Cart getCart() {
        return cart;
    }

    public List<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public List<Producer> getFavoriteProducers() {
        return favoriteProducers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
