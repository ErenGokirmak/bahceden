package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swifties.bahceden.adapters.HotSalesAdapter;

import java.util.ArrayList;

public class CustomerHomeActivity extends AppCompatActivity {

    private RecyclerView categoriesRV;
    private RecyclerView hotSalesRV;
    private RecyclerView newArrivalsRV;
    private RecyclerView.Adapter categoriesAdapter;
    private RecyclerView.Adapter arrivalsAdapter;
    private RecyclerView.Adapter hotSalesAdapter;

    private ImageSlider imageSlider;

    RecyclerView.LayoutManager cLayoutManager;
    RecyclerView.LayoutManager aLayoutManager;
    RecyclerView.LayoutManager hLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.customerNavHome);
        bottomNavigationView.setOnItemSelectedListener(new CustomerNavBarListener(this));

        imageSlider = findViewById(R.id.customerHomeSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banana, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cucumber, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tomato, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        newArrivalsRV = (RecyclerView) findViewById(R.id.customerHomeNewArrivalsRV);
        newArrivalsRV.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        newArrivalsRV.setLayoutManager(aLayoutManager);
        arrivalsAdapter = new HotSalesAdapter();
        newArrivalsRV.setAdapter(arrivalsAdapter);
    }
}