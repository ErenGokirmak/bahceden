package com.swifties.bahceden.fragments;

import android.content.Context;
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
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.CartItem;
import com.swifties.bahceden.models.Producer;
import com.swifties.bahceden.models.Product;

import java.util.ArrayList;
import java.util.HashSet;

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

        cart = new Cart();
        fillCart(cart);

        cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
        cartProductsRV.setHasFixedSize(true);
        cartProductLayoutManager = new LinearLayoutManager(getActivity());

        cartProductsRV.setLayoutManager(cartProductLayoutManager);
        cartProductAdapter = new CartProductAdapter(cart, this.getContext());
        cartProductsRV.setAdapter(cartProductAdapter);
    }

    private void fillCart(Cart cart)
    {
        cart.addItem(new CartItem(new Product(Product.UnitType.KILOGRAMS,
                "Cherry Jam",
                "delicios",
                null,
                new Producer(null,null,"ısparta",null),
                5,5,
                "https://anitalianinmykitchen.com/wp-content/uploads/2022/06/cherry-jam-blog-2-1-of-1.jpg"),
                3));
        cart.addItem(new CartItem(new Product(Product.UnitType.KILOGRAMS,
                "Cherry Jam",
                "delicios",
                null,
                new Producer(null,null,"ısparta",null),
                5,5,
                "https://anitalianinmykitchen.com/wp-content/uploads/2022/06/cherry-jam-blog-2-1-of-1.jpg"),
                3));
        cart.addItem(new CartItem(new Product(Product.UnitType.KILOGRAMS,
                "Cherry Jam",
                "delicios",
                null,
                new Producer(null,null,"ısparta",null),
                5,5,
                "https://anitalianinmykitchen.com/wp-content/uploads/2022/06/cherry-jam-blog-2-1-of-1.jpg"),
                3));
    }
}