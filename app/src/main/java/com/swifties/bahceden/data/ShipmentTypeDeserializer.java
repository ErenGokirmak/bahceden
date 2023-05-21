package com.swifties.bahceden.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.swifties.bahceden.models.Order;

import java.lang.reflect.Type;

public class ShipmentTypeDeserializer implements JsonDeserializer<Order.ShipmentType> {
    @Override
    public Order.ShipmentType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int typeInt = json.getAsInt();
        switch (typeInt) {
            case 0:
                return Order.ShipmentType.CUSTOMER_PICKUP;
            case 1:
                return Order.ShipmentType.PRODUCER_DELIVERY;
            case 2:
                return Order.ShipmentType.SHIPMENT;
            default:
                throw new IllegalArgumentException("Invalid ShipmentType value: " + typeInt);
        }
    }
}
