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
import android.widget.TextView;
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
    private TextView totalPriceText;
    private RecyclerView.Adapter<CartProductAdapter.ViewHolder> cartProductAdapter;
    private RecyclerView.LayoutManager cartProductLayoutManager;
    private Button buyNowButton;
    private Cart cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buyNowButton = view.findViewById(R.id.customerCartBuyNowButton);
        totalPriceText = view.findViewById(R.id.customerCartTotalPriceValue);
        totalPriceText.setText(String.format(getString(R.string.turkish_lira), String.valueOf(0.0)));

        buyNowButton.setOnClickListener(buyView -> {
            Intent intent = new Intent(buyView.getContext(), CustomerCheckOutActivity.class);
            startActivity(intent);
        });
        cart = new Cart(0);

        // create a new cartApi instance
        // get orders from the backend, set the cart's orders to said list, and
        // populate the RecyclerView using that cart (this method will change
        // in the future, for now it just retrieves all orders in the database).
        // TODO: implement retrieving only one customer's orders
        RetrofitService.getApi(OrderApi.class).getAllOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                // setting the cart's orders to the server's response
                cart.setOrders((ArrayList<Order>) response.body());
                cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
                cartProductsRV.setHasFixedSize(true);
                cartProductLayoutManager = new LinearLayoutManager(getActivity());

                // populating the RecyclerView
                cartProductsRV.setLayoutManager(cartProductLayoutManager);
                cartProductAdapter = new CartProductAdapter(cart, CustomerCartFragment.this.getContext());
                cartProductsRV.setAdapter(cartProductAdapter);

                // setting the total price
                // TODO: this only updates the total price once.
                //  there needs to be an update every time the
                //  cart gets updated.
                totalPriceText.setText(String.format(requireContext().getString(R.string.turkish_lira), String.valueOf(cart.calculateTotalCost())));

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                // notify the user about the error
                Toast.makeText(getContext(),
                        "Cart retrieval from the server was unsuccessful", Toast.LENGTH_SHORT).show();
                Log.e("debugPurposes", t.getMessage());
            }
        });

    }
}