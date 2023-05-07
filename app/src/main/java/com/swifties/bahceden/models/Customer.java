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

    @NonNull
    @Override
    public String toString() {

        return "{" +
                "\"user\":" + super.toString() + "," +
                "\"cart\":\"" + cart.toString() + "\"," +
                "\"favoriteProductIds\":\"" + favoriteProductIds.toString() + "\"," +
                "\"favoriteProducerIds\":\"" + favoriteProducerIds.toString() + "\"," +
                "\"orders\":" + orders.toString() +
                "\"addresses\":\"" + addresses.toString() + "\"," +
                "\"cards\":\"" + addresses.toString() + "\",";
    }
}
