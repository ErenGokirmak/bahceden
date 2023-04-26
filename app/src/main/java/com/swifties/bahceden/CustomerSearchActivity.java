package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_search);

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.customerNavSearch);
        bottomNavigationView.setOnItemSelectedListener(new CustomerNavBarListener(this));
    }
}