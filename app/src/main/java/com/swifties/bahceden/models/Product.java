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
}
