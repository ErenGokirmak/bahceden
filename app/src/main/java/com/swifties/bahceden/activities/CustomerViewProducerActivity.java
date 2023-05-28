package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.adapters.ProducerAdapter;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.ProducerApi;
import com.swifties.bahceden.databinding.ActivityCustomerViewProducerBinding;
import com.swifties.bahceden.models.Producer;
import com.swifties.bahceden.uiclasses.GridSpacingItemDecoration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerViewProducerActivity extends AppCompatActivity {
    private RecyclerView producerRV;
    private RecyclerView.Adapter<ProducerAdapter.ViewHolder> producerRVAdapter;
    private RecyclerView.LayoutManager producerLayoutManager;
    private ActivityCustomerViewProducerBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerViewProducerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = getIntent();
        if (!intent.hasExtra("producer_id")) {
            Toast.makeText(this, "Could not find producer.", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }

        RetrofitService.getApi(ProducerApi.class).getProducerById(intent.getIntExtra("producer_id", -1)).enqueue(new Callback<Producer>() {
            @Override
            public void onResponse(Call<Producer> call, Response<Producer> response) {
                if (response.body() != null) {
                    Producer producer = response.body();

                    Picasso.get().load(producer.getBackgroundImageURL().replace("localhost", "10.0.2.2")).into(binding.costumerViewProducerBGImage);
                    Picasso.get().load(producer.getProfileImageURL().replace("localhost", "10.0.2.2")).into(binding.costumerViewProducerImage);

                    binding.customerViewProducerShopName.setText(producer.getShopName());
                    binding.customerViewProducerName.setText(producer.getName());
                    int spanCount = 2;
                    int dp_spacing = 30;
                    int spacing = Math.round(dp_spacing * getResources().getDisplayMetrics().density);
                    boolean includeEdge = false;
                    producerRV = binding.customerViewProducerProductsRV;
                    producerRV.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

                    producerRV.setHasFixedSize(true);
                    producerLayoutManager = new GridLayoutManager(CustomerViewProducerActivity.this, 2);

                    producerRV.setLayoutManager(producerLayoutManager);
                    producerRVAdapter = new ProducerAdapter(producer.getProducts(), CustomerViewProducerActivity.this, getLayoutInflater());
                    producerRV.setAdapter(producerRVAdapter);
                }
            }

            @Override
            public void onFailure(Call<Producer> call, Throwable t) {
                Toast.makeText(CustomerViewProducerActivity.this, "There was an error retrieving producer information.", Toast.LENGTH_SHORT).show();
                Log.d("debugPurposes", t.getMessage());
            }
        });




        binding.customerViewProducerBackButton.setOnClickListener(backView -> CustomerViewProducerActivity.super.onBackPressed());
    }
}