package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.adapters.CategoriesAdapter;
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

        imageSlider = findViewById(R.id.slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banana, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cucumber, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tomato, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        categoriesRV = (RecyclerView) findViewById(R.id.categoriesRV);
        categoriesRV.setHasFixedSize(true);
        cLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        categoriesRV.setLayoutManager(cLayoutManager);
        categoriesAdapter = new CategoriesAdapter();
        categoriesRV.setAdapter(categoriesAdapter);

        newArrivalsRV = (RecyclerView) findViewById(R.id.newArrivalsRV);
        newArrivalsRV.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        newArrivalsRV.setLayoutManager(aLayoutManager);
        arrivalsAdapter = new NewArrivalsAdapter();
        newArrivalsRV.setAdapter(arrivalsAdapter);

    }
}