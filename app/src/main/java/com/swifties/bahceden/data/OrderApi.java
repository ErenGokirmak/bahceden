package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderApi {

    @GET("orders")
    Call<List<Order>> getAllOrders();
}
