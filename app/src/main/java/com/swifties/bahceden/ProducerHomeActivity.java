package com.swifties.bahceden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.YourListingsAdapter;

public class ProducerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_home);

        RecyclerView yourListingsRV = findViewById(R.id.yourListingsRV);

        yourListingsRV.setHasFixedSize(true);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        yourListingsRV.setLayoutManager(lam);

        YourListingsAdapter yla = new YourListingsAdapter();
        yourListingsRV.setAdapter(yla);
    }
}