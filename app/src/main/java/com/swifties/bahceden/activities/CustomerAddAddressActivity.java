package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

public class CustomerAddAddressActivity extends AppCompatActivity {

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_address);

        // Back button and listener initialization
        backButton = findViewById(R.id.customerAddAddressBackButton);
        backButton.setOnClickListener(backView -> CustomerAddAddressActivity.super.onBackPressed());


    }
}