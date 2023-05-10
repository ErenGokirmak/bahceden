package com.swifties.bahceden.models;


import com.swifties.bahceden.data.DBConnection;

public interface Retrievable <T> {
    int getId();
    default T retrieveFromDB(PostAction postAction) {
        new DBConnection(postAction).execute(this);
        return (T) this;
    }
}
