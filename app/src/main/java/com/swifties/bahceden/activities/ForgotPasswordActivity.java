package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.swifties.bahceden.R;
import com.swifties.bahceden.fragments.ChooseActionFragment;
import com.swifties.bahceden.fragments.EnterMailFragment;

public class ForgotPasswordActivity extends AppCompatActivity {
    Button fgtContinue, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        backButton = findViewById(R.id.forgetPasswordBackButton);
        fgtContinue = findViewById(R.id.forgotPasswordContinueButton);

        changeFragment(new EnterMailFragment());

        fgtContinue.setOnClickListener(v -> changeFragment(new ChooseActionFragment()));

        backButton.setOnClickListener(v -> ForgotPasswordActivity.super.onBackPressed());
    }


    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.forgotPasswordFragmentLayout, fragment);
        fragmentTransaction.commit();
    }
}