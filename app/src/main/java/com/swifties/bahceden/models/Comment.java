package com.swifties.bahceden.models;

import java.util.ArrayList;

public class Comment implements Retrievable<Comment>{
    private Customer author;
    private Product product;
    private String contentOfComment;
    private ArrayList<Comment> replies;
    private int numberOfLikes;
    private double rating;
    private int id;

    public int getId() {
        return id;
    }

    public Customer getAuthor() {
        return author;
    }

    public Product getProduct() {
        return product;
    }

    public String getContentOfComment() {
        return contentOfComment;
    }

    public ArrayList<Comment> getReplies() {
        return replies;
    }

    public double getRating() {
        return rating;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }
}
