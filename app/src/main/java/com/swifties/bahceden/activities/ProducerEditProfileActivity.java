package com.swifties.bahceden.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.databinding.ActivityProducerEditProfileBinding;

public class ProducerEditProfileActivity extends AppCompatActivity {

    ActivityProducerEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProducerEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.producerEditProfileBackButton.setOnClickListener(backView -> ProducerEditProfileActivity.super.onBackPressed());

        binding.producerEditProfileUpdateButton.setOnClickListener(updateView -> {
            // TODO: Update the database
        });
    }
}