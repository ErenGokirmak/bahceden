package com.swifties.bahceden.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CartProductAdapter;
import com.swifties.bahceden.data.DBConnection;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.PostAction;
import com.swifties.bahceden.models.Product;
import com.swifties.bahceden.models.Retrievable;

public class CustomerCartFragment extends Fragment {

    private RecyclerView cartProductsRV;
    private RecyclerView.Adapter cartProductAdapter;
    private RecyclerView.LayoutManager cartProductLayoutManager;
    private Cart cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cart = new Cart(0);

        Order order1 = new Order(0);
        Product product1 = new Product(1);
        order1.setProduct(product1);
        Order order2 = new Order(1);
        Product product2 = new Product(2);
        order2.setProduct(product2);
        cart.getOrders().add(order1);
        cart.getOrders().add(order2);

        DBConnection.retrieveFromDB(new PostAction() {
            @Override
            public void action() {
                cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
                cartProductsRV.setHasFixedSize(true);
                cartProductLayoutManager = new LinearLayoutManager(getActivity());

                cartProductsRV.setLayoutManager(cartProductLayoutManager);
                cartProductAdapter = new CartProductAdapter(cart, CustomerCartFragment.this.getContext());
                cartProductsRV.setAdapter(cartProductAdapter);
            }
        }, product1, product2);
    }
}