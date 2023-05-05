package com.swifties.bahceden.models;

import java.util.ArrayList;

public class Comment {
    private Customer author;
    private Product product;
    private String contentOfComment;
    private ArrayList<Comment> replies;
    private int numberOfLikes;
    private double rating;
}
