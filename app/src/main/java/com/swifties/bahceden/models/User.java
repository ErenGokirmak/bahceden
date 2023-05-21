package com.swifties.bahceden.models;

public abstract class User {
    /**
     * Unique identification number of the user.
     */
    private int id;
    /**
     * Name of the user
     */
    private String name;
    /**
     * Email in plain text, including the "@" and "." symbols
     */
    private String email;
    /**
     * Hashed and salted version of a user's password.
     */
    private String password;
    /**
     * The phone number of a user will be of the form "countryCode-phoneNumber"
     */
    private String phoneNumber;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Checks if a given email is valid.
     *
     * @return whether the email of a user object is valid.
     */
    public boolean checkEmail() {
        return true;
    }

    public void fillFrom(User u) {
        email = u.getEmail();
        name = u.getName();
        password = u.getPassword();
        phoneNumber = u.getPhoneNumber();
    }

}
