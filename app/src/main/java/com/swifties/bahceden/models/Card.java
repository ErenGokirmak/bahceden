package com.swifties.bahceden.models;

public class Card {
    private String title;
    private String cardHolderName;
    private long cardNumber;
    private int cvv;
    private String expirationDate; // In the format of "xx/xx"

    public String getTitle() {
        return title;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
