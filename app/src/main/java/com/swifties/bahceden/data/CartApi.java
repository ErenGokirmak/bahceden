package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CartApi {
    @GET("/products")
    Call<List<Product>> getAllProducts();
}
