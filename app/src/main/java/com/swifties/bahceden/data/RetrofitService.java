package com.swifties.bahceden.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swifties.bahceden.data.deserializers.CustomerDeserializer;
import com.swifties.bahceden.data.deserializers.OrderStatusDeserializer;
import com.swifties.bahceden.data.deserializers.ShipmentTypeDeserializer;
import com.swifties.bahceden.data.deserializers.UnitTypeDeserializer;
import com.swifties.bahceden.data.serializers.AddressSerializer;
import com.swifties.bahceden.data.serializers.OrderStatusSerializer;
import com.swifties.bahceden.data.serializers.ShipmentTypeSerializer;
import com.swifties.bahceden.models.Address;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Product;

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
                    .registerTypeAdapter(Order.ShipmentType.class, new ShipmentTypeSerializer())
                    .registerTypeAdapter(Order.OrderStatus.class, new OrderStatusSerializer())
                    .registerTypeAdapter(Address.class, new AddressSerializer())
                    .registerTypeAdapter(Product.UnitType.class, new UnitTypeDeserializer())
                    .registerTypeAdapter(Customer.class, new CustomerDeserializer())
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
