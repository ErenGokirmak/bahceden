package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class logInActivity extends AppCompatActivity {

    Button backButton;
    EditText emailInput, passwordInput;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        backButton = findViewById(R.id.loginBack);
        emailInput = findViewById(R.id.loginEmail);
        passwordInput = findViewById(R.id.loginPassword);
        textInputLayout = findViewById(R.id.loginPasswordLayout);

        textInputLayout.setEndIconVisible(false);

//        Text watcher for email Input
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(logInActivity.this, R.color.black));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(logInActivity.this, R.color.darkGray));
            }
        });

//        Text Watcher for password Input
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(logInActivity.this, R.color.black));
                textInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(logInActivity.this, R.color.darkGray));
                    textInputLayout.setEndIconVisible(false);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(logInActivity.this, IntroActivity.class);
                startActivity(intent);
            }
        });
    }
}