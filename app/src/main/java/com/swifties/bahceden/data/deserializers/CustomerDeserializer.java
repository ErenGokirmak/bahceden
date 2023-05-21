package com.swifties.bahceden.data.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.swifties.bahceden.data.AuthCustomer;
import com.swifties.bahceden.models.Customer;

import java.lang.reflect.Type;

public class CustomerDeserializer implements JsonDeserializer <Customer> {
    @Override
    public Customer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return AuthCustomer.getCustomer();
    }
}
