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
import com.swifties.bahceden.adapters.CommentProducerViewAdapter;
import com.swifties.bahceden.adapters.YourListingsAdapter;

import java.util.ArrayList;

public class ProducerHomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_producer_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageSlider imageSlider = view.findViewById(R.id.producerHomeSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banana, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cucumber, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tomato, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        RecyclerView yourListingsRV = view.findViewById(R.id.yourListingsRV);
        RecyclerView newReviewsRV = view.findViewById(R.id.newReviewsRV);

        newReviewsRV.setHasFixedSize(true);
        yourListingsRV.setHasFixedSize(true);

        RecyclerView.LayoutManager reviewsLM = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        newReviewsRV.setLayoutManager(reviewsLM);
        RecyclerView.LayoutManager listingsLM = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        yourListingsRV.setLayoutManager(listingsLM);

        CommentProducerViewAdapter nra = new CommentProducerViewAdapter();
        newReviewsRV.setAdapter(nra);
        YourListingsAdapter yla = new YourListingsAdapter();
        yourListingsRV.setAdapter(yla);
    }
}