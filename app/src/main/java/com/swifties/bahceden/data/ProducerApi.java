package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Producer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProducerApi {
    @GET("producers")
    Call<List<Producer>> getAllProducers();

    @GET("producers/{producerId}")
    Call<Producer> getProducerById(@Path("producerId") int producerId);

    @GET("producers/{keyword}/search")
    Call<List<Producer>> getProducerByKeyword(@Path("keyword") String keyword);

    @POST("producers/{producerId}")
    Call<Producer> save(@Path("producerId") int id, @Body Producer producer);

    @PUT("producers")
    Call<Producer> updateProducer(@Body Producer producer);


}
