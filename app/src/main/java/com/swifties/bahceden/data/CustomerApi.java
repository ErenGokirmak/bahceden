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
     * @return a list containing all the
     * customers
     */
    @GET("customers")
    Call<List<Customer>> getAllCustomers();

    /**
     * Retrieves a customer from the backend
     * with the given id (if it exists)
     *
     * @param id the id of the customer
     * @return the customer with the given id
     */
    @GET("customers/{customerId}")
    Call<Customer> getCustomerById(@Path("customerId") int id);

    /**
     * Saves a new customer to the database
     *
     * @param customer the new customer data
     * @return the new customer
     */
    @POST("customers")
    Call<Customer> save(@Body Customer customer);

    /**
     * Updates a customer's data on the backend
     * using the data given
     *
     * @param customer the updated customer data
     * @return the updated customer
     */
    @PUT("customers")
    Call<Customer> updateCustomer(@Body Customer customer);

    /**
     * Deletes a customer from the database
     * @param id the id of the customer
     * @return whether deletion attempt was successful or not
     */
    @DELETE("customer/{customerId}")
    Call<String> deleteCustomer(@Path("customerId") int id);
}
