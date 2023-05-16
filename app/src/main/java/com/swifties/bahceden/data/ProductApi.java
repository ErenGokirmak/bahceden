package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {
    @GET("products")
    Call<List<Product>> getAllProducts();



    /**
     * Retrieves a single product from the backend
     * @param id the desired product's id
     * @return the desired product
     */
    @GET("products/{productId}")
    Call<Product> getProductById(@Path("productId") int id);

    @DELETE("products/{productId}")
    Call<Product> deleteProductById(@Path("productId") int id);
}
