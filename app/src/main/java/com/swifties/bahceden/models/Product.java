package com.swifties.bahceden.models;

import java.util.Set;

public class Product {
    private static int totalNoOfProducts = 0;
    UnitType unitType;
    private int id;
    private String name;
    private String description;
    private Set<Comment> comments;
    private Producer producer;
    private double pricePerUnit;
    private double amountInStock;
    private String imageUrl;
    private Rating rating;

    public Product(UnitType unitType,
                   String name,
                   String description,
                   Set<Comment> comments,
                   Producer producer,
                   double pricePerUnit,
                   double amountInStock,
                   String imageUrl) {
        this.unitType = unitType;
        this.id = totalNoOfProducts++;
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.producer = producer;
        this.pricePerUnit = pricePerUnit;
        this.amountInStock = amountInStock;
        this.imageUrl = imageUrl;
    }

    public enum UnitType {
        KILOGRAMS,
        LITERS,
        PACKAGES
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
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
    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
