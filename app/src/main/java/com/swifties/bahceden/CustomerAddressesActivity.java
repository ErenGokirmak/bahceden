package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.swifties.bahceden.adapters.YourAddressesAdapter;

public class CustomerAddressesActivity extends AppCompatActivity {

    RecyclerView addressesRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_addresses);

        addressesRV = findViewById(R.id.customerAddressesYourAddressesRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        addressesRV.setLayoutManager(lam);
        YourAddressesAdapter yaa = new YourAddressesAdapter();
        addressesRV.setAdapter(yaa);
    }
}