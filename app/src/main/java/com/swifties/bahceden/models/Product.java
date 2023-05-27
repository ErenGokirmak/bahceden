package com.swifties.bahceden.models;

import java.util.List;
import java.util.Objects;

public class Product {
    UnitType unitType;
    private int id;
    private String name;
    private String description;

    private List<Comment> comments;
    private Producer producer;
    private double rating;
    private int producerId;
    private double pricePerUnit;
    private double amountInStock;
    private String imageURL;


    public Product() {

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

    public List<Comment> getComments() {
        return comments;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
