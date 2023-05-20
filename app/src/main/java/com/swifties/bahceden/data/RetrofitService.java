package com.swifties.bahceden.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    private RetrofitService() {
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <T> T getApi (Class<T> clazz)
    {
        return (T) RetrofitService.getRetrofit().create(clazz);
    }
}
