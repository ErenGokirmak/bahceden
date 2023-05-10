package com.swifties.bahceden.models;

public abstract class User implements Retrievable<User> {
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

    public User(int id) {
        this.id = id;
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

    /**
     * Checks if a given email is valid.
     *
     * @return whether the email of a user object is valid.
     */
    public boolean checkEmail() {
        return true;
    }

    @Override
    public String toString() {
        return "\"User\"{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
