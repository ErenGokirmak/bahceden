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
import android.widget.TextView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.FavDukkanAdapter;
import com.swifties.bahceden.adapters.FavItemAdapter;

public class CustomerFavoritesFragment extends Fragment {

    private TextView productTxt, dukkanTxt;
    private RecyclerView customerFavoritesItemsRV;
    private RecyclerView customerFavoritesDukkansRV;
    private RecyclerView.Adapter customerFavoritesItemsAdapter;
    private RecyclerView.Adapter customerFavoritesDukkansAdapter;
    private RecyclerView.LayoutManager customerFavoritesItemsLM;
    private RecyclerView.LayoutManager customerFavoritesDukkansLM;

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_customer_favorites, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productTxt = view.findViewById(R.id.customerFavoriteProductsButton);
        dukkanTxt = view.findViewById(R.id.customerFavoriteDukkansButton);


        ButtonsListener listener = new ButtonsListener();

        productTxt.setOnClickListener(listener);
        dukkanTxt.setOnClickListener(listener);
        customerFavoritesItemsRV = view.findViewById(R.id.customerFavoriteProductsRV);
        customerFavoritesItemsRV.setHasFixedSize(true);
        customerFavoritesItemsLM = new LinearLayoutManager(getActivity());
        customerFavoritesItemsAdapter = new FavItemAdapter();
        customerFavoritesItemsRV.setLayoutManager(customerFavoritesItemsLM);
        customerFavoritesItemsRV.setAdapter(customerFavoritesItemsAdapter);


        customerFavoritesDukkansRV = view.findViewById(R.id.customerFavoritesFavDukkansRV);
        customerFavoritesDukkansRV.setHasFixedSize(true);
        customerFavoritesDukkansAdapter = new FavDukkanAdapter();
        customerFavoritesDukkansLM = new LinearLayoutManager(getActivity());
        customerFavoritesDukkansRV.setLayoutManager(customerFavoritesDukkansLM);
        customerFavoritesDukkansRV.setAdapter(customerFavoritesDukkansAdapter);
    }

    private class ButtonsListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.customerFavoriteProductsButton:

                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.white, productTxt.getContext().getTheme()));
                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.darkGray, dukkanTxt.getContext().getTheme()));
                    rootView.findViewById(R.id.customerFavoritesFavDukkansRV).setVisibility(View.GONE);
                    rootView.findViewById(R.id.customerFavoriteProductsRV).setVisibility(View.VISIBLE);
                    break;
                case R.id.customerFavoriteDukkansButton:

                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.white, dukkanTxt.getContext().getTheme()));
                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.darkGray, productTxt.getContext().getTheme()));
                    rootView.findViewById(R.id.customerFavoritesFavDukkansRV).setVisibility(View.VISIBLE);
                    rootView.findViewById(R.id.customerFavoriteProductsRV).setVisibility(View.GONE);
                    break;
            }
        }
    }
}