package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.CustomerCheckOutActivity;
import com.swifties.bahceden.adapters.CartProductAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.models.Order;

import java.util.List;

public class CustomerCartFragment extends Fragment {

    private RecyclerView cartProductsRV;
    private TextView totalPriceText;
    private RecyclerView.Adapter<CartProductAdapter.ViewHolder> cartProductAdapter;
    private RecyclerView.LayoutManager cartProductLayoutManager;
    private Button buyNowButton;
    private List<Order> cart;

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

        cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
    }

    @Override
    public void onResume() {
        super.onResume();

        cart = AuthUser.getCustomer().getCart();

        cartProductsRV.setHasFixedSize(true);
        cartProductLayoutManager = new LinearLayoutManager(getActivity());

        cartProductsRV.setLayoutManager(cartProductLayoutManager);
        cartProductAdapter = new CartProductAdapter(cart, CustomerCartFragment.this.getContext(), totalPriceText);
        cartProductsRV.setAdapter(cartProductAdapter);

        totalPriceText.setText(String.format(requireContext().getString(R.string.turkish_lira), String.valueOf(cart.stream().map(Order::getTotalPrice).reduce(0.0, Double::sum))));
    }
}