package com.swifties.bahceden.models;


import com.swifties.bahceden.data.DBConnection;

public interface Retrievable<T> {
    int getId();

    void fillFrom(T obj);

    default T retrieveFromDB(PostAction postAction) {
        new DBConnection(postAction).execute(this);
        return (T) this;
    }
}
