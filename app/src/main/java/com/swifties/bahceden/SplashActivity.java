package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
<<<<<<< Updated upstream
                Intent intent = new Intent(SplashActivity.this, AnalyticsActivity.class);
=======
                Intent intent = new Intent(SplashActivity.this, ProductActivity.class);
>>>>>>> Stashed changes
                startActivity(intent);
                finish();
            }
        },1000);
    }
}