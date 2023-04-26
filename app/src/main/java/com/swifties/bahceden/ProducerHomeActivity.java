package com.swifties.bahceden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.slider.Slider;
import com.swifties.bahceden.adapters.NewReviewsAdapter;
import com.swifties.bahceden.adapters.YourListingsAdapter;

import java.util.ArrayList;

public class ProducerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.producerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.producerNavHome);
        bottomNavigationView.setOnItemSelectedListener(new ProducerNavBarListener(this));

        ImageSlider imageSlider = findViewById(R.id.producerHomeSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banana, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cucumber, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tomato, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        RecyclerView yourListingsRV = findViewById(R.id.yourListingsRV);
        RecyclerView newReviewsRV = findViewById(R.id.newReviewsRV);

        newReviewsRV.setHasFixedSize(true);

        yourListingsRV.setHasFixedSize(true);

        RecyclerView.LayoutManager reviewsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newReviewsRV.setLayoutManager(reviewsLM);
        RecyclerView.LayoutManager listingsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        yourListingsRV.setLayoutManager(listingsLM);

        NewReviewsAdapter nra = new NewReviewsAdapter();
        newReviewsRV.setAdapter(nra);
        YourListingsAdapter yla = new YourListingsAdapter();
        yourListingsRV.setAdapter(yla);
    }
}