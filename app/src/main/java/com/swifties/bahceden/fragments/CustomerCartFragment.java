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

public class CustomerCartFragment extends Fragment {

    private RecyclerView cartProductsRV;
    private RecyclerView.Adapter cartProductAdapter;
    RecyclerView.LayoutManager cartProductLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cartProductsRV = view.findViewById(R.id.customerCartProductsRV);
        cartProductsRV.setHasFixedSize(true);
        cartProductLayoutManager = new LinearLayoutManager(getActivity());

        cartProductsRV.setLayoutManager(cartProductLayoutManager);
        cartProductAdapter = new CartProductAdapter();
        cartProductsRV.setAdapter(cartProductAdapter);
    }
}