package com.swifties.bahceden;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProducerOrderDetailsActivity extends AppCompatActivity {

    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_order_details);

        backButton = findViewById(R.id.producerOrderDetailsBackButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProducerOrderDetailsActivity.super.onBackPressed();
            }
        });
    }
}