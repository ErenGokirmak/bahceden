package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPasswordActivity extends AppCompatActivity {

    Button fgtContinue, backBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        backBt = findViewById(R.id.forgetPasswordBack);
        fgtContinue = findViewById(R.id.forgetContinue);

        changeFragment(new EnterMailFragment());

        fgtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true)
                    changeFragment(new ChooseActionFragment());
            }
        });

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgetPasswordActivity.super.onBackPressed();
            }
        });
    }


    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment);
        fragmentTransaction.commit();
    }
}