package com.swifties.bahceden.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> cartItems;
    public Cart() {
        cartItems = new ArrayList<>();
    }

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public boolean addItem (CartItem cartItem)
    {
        return cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public int size() {return cartItems.size();}
}
