package com.swifties.bahceden.models;

import androidx.annotation.NonNull;

public class Product implements Retrievable<Product> {
    UnitType unitType;
    private int id;
    private String name;
    private String description;
    //private ArrayList<Comment> comments;
    private Producer producer;
    private int producerId;
    private double pricePerUnit;
    private double amountInStock;
    private String imageURL;

    public Product(int id, String name, String description, int unitType, double pricePerUnit, int producerId,  double amountInStock, String imageURL) {
        this.unitType = UnitType.fromValue(unitType);
        this.id = id;
        this.name = name;
        this.description = description;
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

    public Producer getProducer(boolean sync) {
        //if (sync) producer.retrieveFromDB();
        return this.producer;
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

    @NonNull
    @Override
    public String toString() {
        //return String.valueOf(id);
        return "{\"unitType\":\"" + "1" + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"desc\":\"" + description + "\"," +
                //"\"commentIds\":\"" + comments.toString() + "\"," +
                //"\"producer\":\"" + producer.getId() + "\"," +
                "\"pricePerUnit\":\"" + pricePerUnit + "\"," +
                "\"amountInStock\":\"" + amountInStock + "\"," +
                "\"imageUrl\":\"" + imageURL + "\"," +
                "\"description\":\"0\" }";
    }
}
