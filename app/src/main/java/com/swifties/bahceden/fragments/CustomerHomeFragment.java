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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.HotSalesAdapter;

import java.util.ArrayList;

public class CustomerHomeFragment extends Fragment {
    private RecyclerView newArrivalsRV;
    private RecyclerView.Adapter arrivalsAdapter;

    private ImageSlider imageSlider;

    RecyclerView.LayoutManager cLayoutManager;
    RecyclerView.LayoutManager aLayoutManager;
    RecyclerView.LayoutManager hLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageSlider = view.findViewById(R.id.customerHomeSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banana, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cucumber, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tomato, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        newArrivalsRV = view.findViewById(R.id.customerHomeNewArrivalsRV);
        newArrivalsRV.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        newArrivalsRV.setLayoutManager(aLayoutManager);
        arrivalsAdapter = new HotSalesAdapter();
        newArrivalsRV.setAdapter(arrivalsAdapter);
    }
}