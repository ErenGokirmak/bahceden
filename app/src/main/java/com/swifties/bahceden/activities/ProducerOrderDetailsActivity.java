package com.swifties.bahceden.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.databinding.ActivityProducerOrderDetailsBinding;

public class ProducerOrderDetailsActivity extends AppCompatActivity {

    ActivityProducerOrderDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProducerOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.producerOrderDetailsBackButton.setOnClickListener(backView -> ProducerOrderDetailsActivity.super.onBackPressed());
    }
}