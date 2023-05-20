package com.swifties.bahceden.data;

import android.util.Log;

import com.swifties.bahceden.models.Customer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthCustomer {
    private static Customer customer;

    private AuthCustomer () {}

    public static void initializeCustomer (int id)
    {
        if (customer == null)
        {
            RetrofitService.getApi(CustomerApi.class).getCustomerById(id).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {
                    customer = response.body();
                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    Log.e("Debug", "Customer cannot be initialized.\n" + t.getMessage());
                }
            });
        }
    }

    public static Customer getCustomer ()
    {
        if (customer == null)
        {
            Log.e("Debug", "Customer is not initialized.");
        }
        return customer;
    }
}
