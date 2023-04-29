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

    TextView productTxt, dukkanTxt;
    RecyclerView r1;
    RecyclerView r2;
    RecyclerView.Adapter a1;
    RecyclerView.Adapter a2;
    RecyclerView.LayoutManager l1;
    RecyclerView.LayoutManager l2;

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_customer_favorites, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productTxt = view.findViewById(R.id.customerFavoritesProductsButton);
        dukkanTxt = view.findViewById(R.id.customerFavoritesFavoriteDukkansButton);


        ButtonsListener listener = new ButtonsListener();

        productTxt.setOnClickListener(listener);
        dukkanTxt.setOnClickListener(listener);
        r1 = view.findViewById(R.id.customerFavoritesRV);
        r1.setHasFixedSize(true);
        r2 = view.findViewById(R.id.favDukkans);
        r2.setHasFixedSize(true);
        l1 = new LinearLayoutManager(getActivity());
        l2 = new LinearLayoutManager(getActivity());
        r1.setLayoutManager(l1);
        r2.setLayoutManager(l2);
        a1 = new FavItemAdapter();
        a2 = new FavDukkanAdapter();
        r1.setAdapter(a1);
        r2.setAdapter(a2);
    }

    private class ButtonsListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.customerFavoritesProductsButton:

                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.darkGray, productTxt.getContext().getTheme()));
                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.white, dukkanTxt.getContext().getTheme()));
                    rootView.findViewById(R.id.favDukkans).setVisibility(View.GONE);
                    rootView.findViewById(R.id.customerFavoritesRV).setVisibility(View.VISIBLE);
                    break;
                case R.id.customerFavoritesFavoriteDukkansButton:

                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.darkGray, dukkanTxt.getContext().getTheme()));
                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.white, productTxt.getContext().getTheme()));
                    rootView.findViewById(R.id.favDukkans).setVisibility(View.VISIBLE);
                    rootView.findViewById(R.id.customerFavoritesRV).setVisibility(View.GONE);
                    break;
            }
        }
    }
}