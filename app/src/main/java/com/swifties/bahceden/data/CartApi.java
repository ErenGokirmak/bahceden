package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CartApi {

    // FIXME: I'm not sure if this method should exist, it does exist on the backend so it will stay here for
    /**
     *
     * I'm
     *
     * @return all orders in the database
     */
    @GET("products")
    Call<List<Order>> getAllOrders();

    /**
     * Returns all the orders in a customer's cart. The path includes a "/c" at
     * the start as the backend doesn't distinguish between GET requests made
     * with customer and producer id's (yet).
     *
     * @param customerId id of the customer
     * @return all orders in said customer's cart
     */
    @GET("orders/c{customerId}")
    Call<List<Order>> getCartOfCustomerById(@Path("customerId") int customerId);

    /**
     * Searches through all orders that are in
     * IN_CART status and deletes the order
     * if there exists an order with
     * customer_id set to customerId and
     * product_id set to productId.
     *
     * @param customerId the id of the customer
     * @param productId the id of the product
     * @return the deleted Order
     */
    @DELETE("customer/c{customerId}p{productId}")
    Call<Order> deleteOrderFromCart(@Path("customerId") int customerId, @Path("productId") int productId);
}
