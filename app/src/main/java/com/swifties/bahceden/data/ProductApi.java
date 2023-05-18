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
     * Retrieves a list of products that
     * correspond to a given keyword
     *
     * @param keyword keyword to be searched for
     * @return a list of products
     */
    @GET("products/{keyword}/search")
    Call<List<Product>> getProductsByKeyword(@Path("keyword") String keyword);

    /**
     * Retrieves a single product from the backend
     *
     * @param id the desired product's id
     * @return the desired product
     */
    @GET("products/{productId}")
    Call<Product> getProductById(@Path("productId") int id);

    /**
     * Deletes the product from the database
     *
     * @param id the id of the product
     * @return whether deletion was successful or not
     */
    @DELETE("products/{productId}")
    Call<String> deleteProductById(@Path("productId") int id);
}
