package com.swifties.bahceden.data;

import com.google.gson.Gson;
import com.swifties.bahceden.models.Retrievable;

public class Parser {
    public static void parse (String dataString, Retrievable r)
    {
        Gson gson = new Gson();
        r.fillFrom(
                gson.fromJson(dataString, r.getClass())
        );
    }
}
