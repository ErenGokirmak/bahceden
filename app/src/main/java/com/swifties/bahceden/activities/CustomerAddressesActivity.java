package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.YourAddressesAdapter;

public class CustomerAddressesActivity extends AppCompatActivity {

    private RecyclerView addressesRV;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_addresses);

        backButton = findViewById(R.id.customerAddressesBackButton);
        backButton.setOnClickListener(view -> CustomerAddressesActivity.super.onBackPressed());

        addressesRV = findViewById(R.id.customerAddressesYourAddressesRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        addressesRV.setLayoutManager(lam);
        YourAddressesAdapter yaa = new YourAddressesAdapter();
        addressesRV.setAdapter(yaa);
    }
}