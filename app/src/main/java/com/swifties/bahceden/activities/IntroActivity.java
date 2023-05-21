package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

public class IntroActivity extends AppCompatActivity {

    public static final int PRODUCER_TYPE = 1;
    public static final int CUSTOMER_TYPE = 2;
    Button customerButton, producerButton;
    TextView haveAnAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        customerButton = findViewById(R.id.introCustomerButton);
        producerButton = findViewById(R.id.introProducerButton);
        haveAnAccount = findViewById(R.id.introAlreadyHaveAnAccountButton);

        customerButton.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
            intent.putExtra("userType", 2);
            startActivity(intent);
        });

        producerButton.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
            intent.putExtra("userType", 1);
            startActivity(intent);
        });

        haveAnAccount.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this, LogInActivity.class);
            startActivity(intent);
        });
    }
}