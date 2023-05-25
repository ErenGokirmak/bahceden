package com.swifties.bahceden.models;

import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.data.apis.OrderApi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
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
        super();
        favoriteProducts = new ArrayList<>();
        favoriteProducers = new ArrayList<>();
        orders = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    public void setFavoriteProducts(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public void setFavoriteProducers(List<Producer> favoriteProducers) {
        this.favoriteProducers = favoriteProducers;
    }


    public void setOrders(List<Order> orders) {
        this.orders = orders;
        this.cart = new Cart(orders.stream().filter(order -> order.getStatus() == Order.OrderStatus.IN_CART).collect(Collectors.toList()), getId());
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

    public void addNewOrder (Product p, int amount)
    {
        Optional<Order> orderOptional = this.orders.stream().filter(o -> o.getStatus() == Order.OrderStatus.IN_CART).filter(o -> o.getProduct().equals(p)).findFirst();
        if (orderOptional.isPresent())
        {
            Order oldOrder = orderOptional.get();
            RetrofitService.getApi(OrderApi.class).putOrder(oldOrder).enqueue(new Callback<Order>() {
                @Override
                public void onResponse(Call<Order> call, Response<Order> response) {
                    Order newOrder = response.body();
                    Customer.this.orders.remove(oldOrder);
                    Customer.this.orders.add(newOrder);
                }

                @Override
                public void onFailure(Call<Order> call, Throwable t) {
                    throw new RuntimeException(t);
                }
            });
        }
        else
        {
            Order newOrder = new Order();
            newOrder.setProduct(p);
            newOrder.setDeliveryAddress(addresses.get(0));
            newOrder.setStatus(Order.OrderStatus.IN_CART);
            newOrder.setShipmentType(Order.ShipmentType.CUSTOMER_PICKUP);
            newOrder.setAmount(amount);
            newOrder.setDateOfPurchase(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
            RetrofitService.getApi(OrderApi.class).postOrder(newOrder).enqueue(new Callback<Order>() {
                @Override
                public void onResponse(Call<Order> call, Response<Order> response) {
                    Order order = response.body();
                    Customer.this.orders.add(order);
                }

                @Override
                public void onFailure(Call<Order> call, Throwable t) {
                    throw new RuntimeException(t);
                }
            });
        }
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
