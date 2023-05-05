package com.swifties.bahceden.models;

import java.util.Set;

public class Product {
    UnitType unitType;
    private int id;
    private String name;
    private String description;
    private Set<Comment> comments;
    private Producer producer;
    private double amountInStock;

    private enum UnitType {
        KILOGRAMS,
        LITERS,
        PACKAGES
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public Producer getProducer() {
        return producer;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public String getDescription() {
        return description;
    }

    public UnitType getUnitType() {
        return unitType;
    }
}
