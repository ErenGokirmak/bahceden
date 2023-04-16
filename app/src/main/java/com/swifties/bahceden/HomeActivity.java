package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView categoriesRV;
    private RecyclerView hotSalesRV;
    private RecyclerView newArrivalsRV;
    private RecyclerView.Adapter categoriesAdapter;
    private RecyclerView.Adapter arrivalsAdapter;
    private RecyclerView.Adapter hotSalesAdapter;

    RecyclerView.LayoutManager cLayoutManager;
    RecyclerView.LayoutManager aLayoutManager;
    RecyclerView.LayoutManager hLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categoriesRV = (RecyclerView) findViewById(R.id.categoriesRV);
        categoriesRV.setHasFixedSize(true);
        cLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        categoriesRV.setLayoutManager(cLayoutManager);
        categoriesAdapter = new CategoriesAdapter();
        categoriesRV.setAdapter(categoriesAdapter);

        hotSalesRV = (RecyclerView) findViewById(R.id.hotSalesRV);
        hotSalesRV.setHasFixedSize(true);
        hLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        hotSalesRV.setLayoutManager(hLayoutManager);
        hotSalesAdapter = new HotSalesAdapter();
        hotSalesRV.setAdapter(hotSalesAdapter);

        newArrivalsRV = (RecyclerView) findViewById(R.id.newArrivalsRV);
        newArrivalsRV.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        newArrivalsRV.setLayoutManager(aLayoutManager);
        arrivalsAdapter = new HotSalesAdapter();
        newArrivalsRV.setAdapter(arrivalsAdapter);



    }
}