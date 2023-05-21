package com.swifties.bahceden.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swifties.bahceden.models.Order;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    private RetrofitService() {
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null)
        {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Order.ShipmentType.class, new ShipmentTypeDeserializer())
                    .registerTypeAdapter(Order.OrderStatus.class, new OrderStatusDeserializer())
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static <T> T getApi (Class<T> clazz)
    {
        return (T) RetrofitService.getRetrofit().create(clazz);
    }
}
