package com.swifties.bahceden.models;

import java.util.Set;

public class Order {
    private enum ShipmentType {
        CUSTOMER_PICKUP,
        PRODUCER_DELIVERY,
        SHIPMENT
    }

    private int id;
    private String dateOfPurchase;
    private Set<Product> products;
    private Customer receiver;
    private ShipmentType shipmentType;
    private Address address;
}
