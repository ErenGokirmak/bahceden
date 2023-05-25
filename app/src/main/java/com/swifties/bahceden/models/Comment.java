package com.swifties.bahceden.models;

public class Comment {
    private Customer author;
    private Product product;
    private String message;
    private Comment parent;
    private int countOfLikes;
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
        return message;
    }
    public int getNumberOfLikes() {
        return countOfLikes;
    }
}
