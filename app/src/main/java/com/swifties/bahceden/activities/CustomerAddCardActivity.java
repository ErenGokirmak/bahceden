package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

public class CustomerAddCardActivity extends AppCompatActivity {
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_card);

        backButton = findViewById(R.id.customerAddCardBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerAddCardActivity.super.onBackPressed();
            }
        });
    }
}