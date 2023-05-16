package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.CustomerCheckOutActivity;
import com.swifties.bahceden.adapters.CartProductAdapter;
import com.swifties.bahceden.data.OrderApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerCartFragment extends Fragment {

    private RecyclerView cartProductsRV;
    private RecyclerView.Adapter<CartProductAdapter.ViewHolder> cartProductAdapter;
    private RecyclerView.LayoutManager cartProductLayoutManager;
    private Button buyNowButton;
    private Cart cart;
    private RetrofitService retrofitService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buyNowButton = view.findViewById(R.id.customerCartBuyNowButton);
        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CustomerCheckOutActivity.class);
                startActivity(intent);
            }
        });
        cart = new Cart(0);
        retrofitService = new RetrofitService();

        OrderApi cartApi = retrofitService.getRetrofit().create(OrderApi.class);

        cartApi.getAllOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                cart.setOrders((ArrayList<Order>) response.body());
                System.out.println("Did work");
                cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
                cartProductsRV.setHasFixedSize(true);
                cartProductLayoutManager = new LinearLayoutManager(getActivity());

                cartProductsRV.setLayoutManager(cartProductLayoutManager);
                cartProductAdapter = new CartProductAdapter(cart, CustomerCartFragment.this.getContext());
                cartProductsRV.setAdapter(cartProductAdapter);
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                System.out.println(call.request());
                Toast.makeText(getContext(),
                        "Didn't work for some reason", Toast.LENGTH_SHORT).show();
                Log.e("debugPurposes" ,t.getMessage());
            }
        });

        System.out.println(cart.getOrders());


    }
}