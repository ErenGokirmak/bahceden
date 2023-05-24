package com.swifties.bahceden.data.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.swifties.bahceden.models.Producer;

import java.lang.reflect.Type;

public class ProducerSerializer implements JsonSerializer<Producer> {
    @Override
    public JsonElement serialize(Producer src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
