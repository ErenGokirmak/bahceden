package com.swifties.bahceden.data.serializers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.swifties.bahceden.models.Product;

import java.lang.reflect.Type;

public class ProductSerializer implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", src.getId());
        obj.addProperty("name", src.getName());
        obj.addProperty("producer_id", src.getProducer().getId());
        obj.addProperty("description", src.getDescription());
        obj.addProperty("rating", src.getRating());
        obj.addProperty("unit_type", src.getUnitType().getValue());
        //obj.addProperty("category", src.getCategory().getId());
        //obj.addProperty("comments", new Gson().toJson(src.getComments()));
        obj.addProperty("price_per_unit", src.getPricePerUnit());
        obj.addProperty("image_url", src.getImageURL());
        obj.addProperty("available_amount", src.getAmountInStock());

        return obj;
    }
}
