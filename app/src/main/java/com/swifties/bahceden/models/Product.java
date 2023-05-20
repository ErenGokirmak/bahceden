package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product {
    UnitType unitType;
    private int id;
    private String name;
    private String description;
    //private ArrayList<Comment> comments;
    private Producer producer;
    private double rating;
    private int producerId;
    private double pricePerUnit;
    private double amountInStock;
    private String imageURL;

    public Product(int id, String name, String description, int unitType, double rating, double pricePerUnit, int producerId, double amountInStock, String imageURL) {
        this.unitType = UnitType.fromValue(unitType);
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.producerId = producerId;
        this.producer = new Producer(producerId);
        this.pricePerUnit = pricePerUnit;
        this.amountInStock = amountInStock;
        this.imageURL = imageURL;
    }

    public Product(int id) {
        this.id = id;
    }

    public enum UnitType {
        KILOGRAMS(1),
        LITERS(2),
        PACKAGES(3);

        private final int value;

        UnitType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static UnitType fromValue(int value) {
            for (UnitType unitType : UnitType.values()) {
                if (unitType.value == value) {
                    return unitType;
                }
            }
            throw new IllegalArgumentException("Invalid unit type value: " + value);
        }
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getId() {
        return id;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public Producer getProducer() {
        //if (sync) producer.retrieveFromDB();
        return this.producer;
    }

    public double getRating() {
        return rating;
    }

    //    public ArrayList<Comment> getComments() {
//        for (Comment c : comments) {
//            ConnectionFactory.get(c);
//        }
//        return comments;
//    }

    public String getDescription() {
        return description;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setAmountInStock(double amountInStock) {
        this.amountInStock = amountInStock;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void fillFrom(Product p) {
        setId(p.getId());
        setName(p.getName());
        setDescription(p.getDescription());
        setUnitType(p.getUnitType());
        setPricePerUnit(p.getPricePerUnit());
        setProducer(p.getProducer());
        setAmountInStock(p.getAmountInStock());
        setImageURL(p.getImageURL());
    }

}
