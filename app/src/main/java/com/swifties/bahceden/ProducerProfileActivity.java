package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProducerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.producerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.producerNavProfile);
        bottomNavigationView.setOnItemSelectedListener(new ProducerNavBarListener(this));

    }
}