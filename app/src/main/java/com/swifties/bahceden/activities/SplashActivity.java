package com.swifties.bahceden.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.swifties.bahceden.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // TODO: Make this into the "logged in" check
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, CustomerMainActivity.class);
            startActivity(intent);
            finish();
        }, 1000);
    }
}