package com.swifties.bahceden;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.ProducerAdapter;
import com.swifties.bahceden.classes.GridSpacingItemDecoration;

public class CustomerViewProducerActivity extends AppCompatActivity {
    private RecyclerView producerRV;
    private RecyclerView.Adapter ProducerAdapter;
    RecyclerView.LayoutManager producerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_producer);

        producerRV = (RecyclerView) findViewById(R.id.costumerViewProducerProductsRV);

        int spanCount = 2;
        int dp_spacing = 30;
        int spacing = Math.round(dp_spacing * getResources().getDisplayMetrics().density);
        boolean includeEdge = false;
        producerRV.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        producerRV.setHasFixedSize(true);
        producerLayoutManager = new GridLayoutManager(this, 2);

        producerRV.setLayoutManager(producerLayoutManager);
        ProducerAdapter = new ProducerAdapter();
        producerRV.setAdapter(ProducerAdapter);
    }
}