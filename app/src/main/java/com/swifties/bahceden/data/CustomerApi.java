package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CustomerApi {
    @GET("/customers")
    Call<List<Customer>> getAllCustomers();

    @GET("/customers/")
    Call<Customer> getCustomerById(int id);

    @POST("/customers/")
    Call<Customer> save(@Body Customer customer);

    /**
     * Used to update the data of a customer
     * @param customer the new customer data
     */
    @PUT("/customers/")
    Call<Customer> updateCustomer(@Body Customer customer);
}
