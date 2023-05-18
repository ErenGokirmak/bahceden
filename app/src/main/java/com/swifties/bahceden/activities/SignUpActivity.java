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

public class SignUpActivity extends AppCompatActivity {

    Button backButton, signUp;
    TextView haveAnAccount;
    EditText nameInput, emailInput, passwordInput, confirmPasswordInput;
    TextInputLayout passwordInputLayout, confirmPasswordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backButton = findViewById(R.id.signUpBackButton);
        signUp = findViewById(R.id.signUpButton);
        nameInput = findViewById(R.id.signUpNameField);
        emailInput = findViewById(R.id.signUpEmailField);
        haveAnAccount = findViewById(R.id.signUpHaveAnAccountButton);
        passwordInput = findViewById(R.id.signUpPasswordField);
        confirmPasswordInput = findViewById(R.id.signUpConfirmPasswordField);
        passwordInputLayout = findViewById(R.id.signUpPasswordLayout);
        confirmPasswordInputLayout = findViewById(R.id.signUpConfirmPasswordLayout);

        passwordInputLayout.setEndIconVisible(false);
        confirmPasswordInputLayout.setEndIconVisible(false);

        //        Text watcher for name Input
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nameInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.bahceden_green));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    nameInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.darkGray));
            }
        });

        //        Text watcher for email Input
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.bahceden_green));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.darkGray));
            }
        });

//        Text Watcher for password Input
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.bahceden_green));
                passwordInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.darkGray));
                    passwordInputLayout.setEndIconVisible(false);
                }
            }
        });

        //        Text Watcher for confirm password Input
        confirmPasswordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confirmPasswordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.bahceden_green));
                confirmPasswordInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    confirmPasswordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(SignUpActivity.this, R.color.darkGray));
                    confirmPasswordInputLayout.setEndIconVisible(false);
                }
            }
        });

        signUp.setOnClickListener(v -> {
            if (nameInput.getText().toString().isEmpty()) {
                nameInput.setError("Name Can't be Empty!");
            } else if (emailInput.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput.getText().toString()).matches()) {
                emailInput.setError("Enter a Valid Email Address!");
            } else if (passwordInput.getText().toString().isEmpty()) {
                passwordInput.setError("Password Can't be Empty!");
            } else if (confirmPasswordInput.getText().toString().isEmpty()) {
                confirmPasswordInput.setError("Confirm Password Can't be Empty!");
            } else if (!passwordInput.getText().toString().equals(confirmPasswordInput.getText().toString())) {
                confirmPasswordInputLayout.setEndIconVisible(false);
                confirmPasswordInput.setError("Passwords Don't Match!");
            }
        });

        haveAnAccount.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> SignUpActivity.super.onBackPressed());

    }
}