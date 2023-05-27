package com.swifties.bahceden.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.CheckOutAdapter;
import com.swifties.bahceden.data.apis.OrderApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.databinding.ActivityCustomerCheckOutBinding;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerCheckOutActivity extends AppCompatActivity {

    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager checkOutRcLayoutManager;
    private Cart cart;
    private ActivityCustomerCheckOutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerCheckOutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.customerCheckOutBackButton.setOnClickListener(backView -> CustomerCheckOutActivity.super.onBackPressed());

        //cart = new Cart(0);

        // TODO: Turn this into the orders of the user that are in cart
        RetrofitService.getApi(OrderApi.class).getAllOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                cart.setOrders(response.body());

                binding.customerCheckOutOrdersRV.setHasFixedSize(true);
                checkOutRcLayoutManager = new LinearLayoutManager(CustomerCheckOutActivity.this);

                binding.customerCheckOutOrdersRV.setLayoutManager(checkOutRcLayoutManager);
                checkOutAdapter = new CheckOutAdapter(cart, CustomerCheckOutActivity.this);
                binding.customerCheckOutOrdersRV.setAdapter(checkOutAdapter);

            }

            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable t) {

            }
        });

    }
}