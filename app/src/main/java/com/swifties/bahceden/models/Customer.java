package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
public class Customer extends User {
    Cart cart;
    ArrayList<Integer> favoriteProductIds;
    ArrayList<Integer> favoriteProducerIds;
    ArrayList<Order> orders;
    ArrayList<Address> addresses;
    ArrayList<Card> cards;

    public Customer(int id) {
        super(id);
    }


    public Cart getCart() {
        return cart;
    }

    public ArrayList<Integer> getFavoriteProducts() {
        return favoriteProducerIds;
    }

    public ArrayList<Integer> getFavoriteProducers() {
        return favoriteProducerIds;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        String userJson = super.toString();
        String customerJson = "\"Customer\":{" +
                "cart=" + cart +
                ", favoriteProductIds=" + favoriteProductIds +
                ", favoriteProducerIds=" + favoriteProducerIds +
                ", orders=" + orders +
                ", addresses=" + addresses +
                ", cards=" + cards +
                '}';
        return "{" + userJson + ", " + customerJson + "}";
    }
}
