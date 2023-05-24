package com.swifties.bahceden.data.apis;

import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Producer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProducerApi {

    /**
     * Retrieves all the producers in
     * the database
     *
     * @return a list of all the producers
     * the database
     */
    @GET("producers")
    Call<List<Producer>> getAllProducers();

    /**
     * Retrieves (if it exists) a producer from
     * the database with the given id
     *
     * @param producerId the producer's id
     * @return a producer instance
     */
    @GET("producers/{producerId}")
    Call<Producer> getProducerById(@Path("producerId") int producerId);

    /**
     * retrieve producer according to the email for the log in purposes
     * @param email
     * @return producer with given email
     */
    @GET("producers/email")
    Call<Customer> getProducerByEmail(@Query("email") String email);

    /**
     * Retrieves all the producers that
     * contain a given keyword in their
     * name
     *
     * @param keyword the given keyword
     * @return all producers that contain
     * the keyword in their name
     */
    @GET("producers/{keyword}/search")
    Call<List<Producer>> getProducerByKeyword(@Path("keyword") String keyword);

    /**
     * Saves a new producer onto the database
     *
     * @param producer the producer that will be saved
     * @return a copy of the producer that was saved
     */
    @POST("producers")
    Call<Producer> save(@Body Producer producer);

    /**
     * Updates a producer in the database with
     * the given information
     *
     * @param producer the updated producer object
     * @return a copy of the producer that was updated
     */
    @PUT("producers")
    Call<Producer> updateProducer(@Body Producer producer);




}
