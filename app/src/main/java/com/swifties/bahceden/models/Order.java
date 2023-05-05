package com.swifties.bahceden.models;

import java.text.SimpleDateFormat;
import java.util.Set;

public class Order {
    private enum ShipmentType {
        CUSTOMER_PICKUP, PRODUCER_DELIVERY, SHIPMENT
    }

    private int id;
    private SimpleDateFormat dateOfPurchase;
    private Set<Product> products;
    private Customer receiver;
    private ShipmentType shipmentType;
    private Address address;

    public int getId() {
        return id;
    }

    public SimpleDateFormat getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Address getAddress() {
        return address;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }
}