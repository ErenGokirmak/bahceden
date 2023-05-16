package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Producer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ProducerApi {
    @GET("/producers")
    Call<List<Producer>> getAllProducers();

    @GET("/producers/")
    Call<Producer> getProducerById(int id);

    @POST("/producers")
    Call<Producer> save(@Body Producer producer);

    @PUT("/producers")
    Call<Producer> updateProducer(@Body Producer producer);


}
