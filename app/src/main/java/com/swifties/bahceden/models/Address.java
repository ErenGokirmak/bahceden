package com.swifties.bahceden.models;

public class Address {
    private String title;
    private String fullAddress;
    private String phoneNumberOfRecipient;

    public String getTitle() {
        return title;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getPhoneNumberOfRecipient() {
        return phoneNumberOfRecipient;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setPhoneNumberOfRecipient(String phoneNumberOfRecipient) {
        this.phoneNumberOfRecipient = phoneNumberOfRecipient;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
