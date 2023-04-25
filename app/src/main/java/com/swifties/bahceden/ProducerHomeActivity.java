package com.swifties.bahceden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.NewReviewsAdapter;
import com.swifties.bahceden.adapters.YourListingsAdapter;

public class ProducerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_home);

        RecyclerView yourListingsRV = findViewById(R.id.yourListingsRV);
        RecyclerView newReviewsRV = findViewById(R.id.newReviewsRV);

        newReviewsRV.setHasFixedSize(true);

        yourListingsRV.setHasFixedSize(true);

        RecyclerView.LayoutManager reviewsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newReviewsRV.setLayoutManager(reviewsLM);
        RecyclerView.LayoutManager listingsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        yourListingsRV.setLayoutManager(listingsLM);

        NewReviewsAdapter nra = new NewReviewsAdapter();
        newReviewsRV.setAdapter(nra);
        YourListingsAdapter yla = new YourListingsAdapter();
        yourListingsRV.setAdapter(yla);
    }
}