package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.ProducerAdapter;
import com.swifties.bahceden.uiclasses.GridSpacingItemDecoration;

public class CustomerViewProducerActivity extends AppCompatActivity {
    private RecyclerView producerRV;
    private ImageView backButton;
    private RecyclerView.Adapter<ProducerAdapter.ViewHolder> producerRVAdapter;
    RecyclerView.LayoutManager producerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_producer);

        backButton = findViewById(R.id.customerViewProducerBackButton);
        backButton.setOnClickListener(backView -> CustomerViewProducerActivity.super.onBackPressed());

        producerRV = findViewById(R.id.costumerViewProducerProductsRV);

        int spanCount = 2;
        int dp_spacing = 30;
        int spacing = Math.round(dp_spacing * getResources().getDisplayMetrics().density);
        boolean includeEdge = false;
        producerRV.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        producerRV.setHasFixedSize(true);
        producerLayoutManager = new GridLayoutManager(this, 2);

        producerRV.setLayoutManager(producerLayoutManager);
        producerRVAdapter = new ProducerAdapter();
        producerRV.setAdapter(producerRVAdapter);
    }
}