package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

public class IntroActivity extends AppCompatActivity {

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
            startActivity(intent);
        });

        producerButton.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        haveAnAccount.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this, LogInActivity.class);
            startActivity(intent);
        });
    }
}