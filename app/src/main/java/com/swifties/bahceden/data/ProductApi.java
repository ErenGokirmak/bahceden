package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("/products")
    Call<List<Product>> getAllProducts();

    @GET("/products")
    Call<Product> getProductById(int id);
}
