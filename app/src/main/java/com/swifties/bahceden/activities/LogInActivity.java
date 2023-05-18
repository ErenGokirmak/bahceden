package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.swifties.bahceden.R;

public class LogInActivity extends AppCompatActivity {

    Button backButton, logIn;
    TextView dontHaveAccount, forgetPassword;
    EditText emailInput, passwordInput;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        backButton = findViewById(R.id.loginBackButton);
        emailInput = findViewById(R.id.loginEmail);
        dontHaveAccount = findViewById(R.id.dontHaveAccount);
        passwordInput = findViewById(R.id.loginPassword);
        textInputLayout = findViewById(R.id.loginPasswordLayout);
        forgetPassword = findViewById(R.id.forgetPassword);
        logIn = findViewById(R.id.logIn);

        textInputLayout.setEndIconVisible(false);

//        Text watcher for email Input
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(LogInActivity.this, R.color.bahceden_green));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(LogInActivity.this, R.color.darkGray));
            }
        });

//        Text Watcher for password Input
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(LogInActivity.this, R.color.bahceden_green));
                textInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(LogInActivity.this, R.color.darkGray));
                    textInputLayout.setEndIconVisible(false);
                }
            }
        });

        logIn.setOnClickListener(v -> {
            if (emailInput.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput.getText().toString()).matches()) {
                emailInput.setError("Enter Valid Email Address!");
            } else if (passwordInput.getText().toString().isEmpty()) {
                passwordInput.setError("Password Can't be Empty!");
            }
        });

        dontHaveAccount.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        forgetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> LogInActivity.super.onBackPressed());
    }
}