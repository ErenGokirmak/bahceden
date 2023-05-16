package com.swifties.bahceden.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CheckOutAdapter;
import com.swifties.bahceden.data.OrderApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerCheckOutActivity extends AppCompatActivity {

    private ImageView backButton;
    private RecyclerView checkOutRc;
    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager checkOutRcLayoutManager;
    private Cart cart;
    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_check_out);

        backButton = findViewById(R.id.customerCheckOutBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerCheckOutActivity.super.onBackPressed();
            }
        });

        retrofitService = new RetrofitService();

        cart = new Cart(0);

        OrderApi cartApi = retrofitService.getRetrofit().create(OrderApi.class);

        cartApi.getAllOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                cart.setOrders((ArrayList<Order>) response.body());

                checkOutRc = findViewById(R.id.customerCheckOutOrdersRV);
                checkOutRc.setHasFixedSize(true);
                checkOutRcLayoutManager = new LinearLayoutManager(CustomerCheckOutActivity.this);

                checkOutRc.setLayoutManager(checkOutRcLayoutManager);
                checkOutAdapter = new CheckOutAdapter(cart, CustomerCheckOutActivity.this);
                checkOutRc.setAdapter(checkOutAdapter);

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });

    }
}