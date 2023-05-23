package com.swifties.bahceden.models;

public class Address {
    private int id;
    private String title;
    private String fullAddress;
    private String phoneNumberOfRecipient;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Address(String title, String fullAddress, String phoneNumberOfRecipient, Customer customer) {
        this.title = title;
        this.fullAddress = fullAddress;
        this.phoneNumberOfRecipient = phoneNumberOfRecipient;
        this.customer = customer;
    }
}
