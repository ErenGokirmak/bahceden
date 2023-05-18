package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OrderApi {

    @GET("orders")
    Call<List<Order>> getAllOrders();

    @DELETE("orders/{orderId}")
    Call<Order> deleteById(@Path("orderId") int id);
}
