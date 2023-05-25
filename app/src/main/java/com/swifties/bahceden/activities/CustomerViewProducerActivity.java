package com.swifties.bahceden.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.ProducerAdapter;
import com.swifties.bahceden.databinding.ActivityCustomerViewProducerBinding;
import com.swifties.bahceden.uiclasses.GridSpacingItemDecoration;

public class CustomerViewProducerActivity extends AppCompatActivity {
    private RecyclerView producerRV;
    private RecyclerView.Adapter<ProducerAdapter.ViewHolder> producerRVAdapter;
    private RecyclerView.LayoutManager producerLayoutManager;
    private ActivityCustomerViewProducerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerViewProducerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customerViewProducerBackButton.setOnClickListener(backView -> CustomerViewProducerActivity.super.onBackPressed());

        producerRV = binding.costumerViewProducerProductsRV;

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