package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CustomerApi {
    /**
     * Retrieves all the customers in the
     * database
     *
     * @return A list containing all the
     * customers
     */
    @GET("customers")
    Call<List<Customer>> getAllCustomers();

    /**
     * Retrieves a customer from the backend
     * with the given id (if it exists)
     *
     * @param id The id of the customer
     * @return The customer with the given id
     */
    @GET("customers/{customerId}")
    Call<Customer> getCustomerById(@Path("customerId") int id);

    /**
     * Saves a new customer to the database
     *
     * @param customer The new customer data
     * @return The new customer
     */
    @POST("customers")
    Call<Customer> save(@Body Customer customer);

    /**
     * Updates a customer's data on the backend
     * using the data given
     *
     * @param customer The updated customer data
     * @return The updated customer
     */
    @PUT("customers")
    Call<Customer> updateCustomer(@Body Customer customer);

    /**
     * Deletes a customer from the database
     *
     * @param id The id of the customer
     * @return Whether deletion attempt was successful or not
     */
    @DELETE("customer/{customerId}")
    Call<String> deleteCustomer(@Path("customerId") int id);

}
