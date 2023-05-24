package com.swifties.bahceden;

import com.google.gson.Gson;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Producer;

public class Test {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setEmail("ss@ss.com");
        c.setName("SS");
        c.setPhoneNumber("1111111111");

        Gson gson = new Gson();

        System.out.println(gson.toJson(c));
    }
}
