package com.swifties.bahceden.models;

import android.util.Log;

import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public boolean addNewFavProduct (Product product)
    {
        if (getFavoriteProducts().add(product))
        {
            RetrofitService.getApi(CustomerApi.class).postNewFavoriteProduct(getId(), product.getId()).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {

                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {

                }
            });
            return true;
        }
        return false;
    }
    public boolean removeFavProduct (Product product)
    {
        if (getFavoriteProducts().remove(product))
        {
            RetrofitService.getApi(CustomerApi.class).deleteNewFavoriteProduct(getId(), product.getId()).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {

                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {

                }
            });
            return true;
        }
        return false;
    }

    public boolean addNewFavProducer (Producer producer)
    {
        if (getFavoriteProducers().add(producer))
        {
            RetrofitService.getApi(CustomerApi.class).postNewFavoriteProduct(getId(), producer.getId()).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {

                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {

                }
            });
            return true;
        }
        return false;
    }
    public boolean removeFavProducer (Producer producer)
    {
        if (getFavoriteProducers().remove(producer))
        {
            RetrofitService.getApi(CustomerApi.class).deleteNewFavoriteProduct(getId(), producer.getId()).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {

                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {

                }
            });
            return true;
        }
        return false;
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
