package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

public class ProducerOrderDetailsActivity extends AppCompatActivity {

    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_order_details);

        backButton = findViewById(R.id.producerOrderDetailsBackButton);

        backButton.setOnClickListener(view -> ProducerOrderDetailsActivity.super.onBackPressed());
    }
}