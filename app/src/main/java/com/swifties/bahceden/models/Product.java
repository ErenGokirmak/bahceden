package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.util.Set;

public class Product {
    UnitType unitType;
    private int id;
    private String name;
    private String description;
    private Set<Comment> comments;
    private Producer producer;
    private double pricePerUnit;
    private double amountInStock;
    private String imageUrl;

    public Product(UnitType unitType,
                   String name,
                   String description,
                   Set<Comment> comments,
                   Producer producer,
                   double pricePerUnit,
                   double amountInStock,
                   String imageUrl) {
        this.unitType = unitType;
        this.id = -1;
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

    @NonNull
    @Override
    public String toString() {
        return "{\"unitType\":\"" + "1" + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"desc\":\"" + description + "\"," +
                "\"comments\":\"" + comments + "\"," +
                "\"producer\":\"" + producer + "\"," +
                "\"pricePerUnit\":\"" + pricePerUnit + "\"," +
                "\"amountInStock\":\"" + amountInStock + "\"," +
                "\"imageUrl\":\"" + imageUrl + "\"," +
                "\"description\":\"0\" }";
    }
}
