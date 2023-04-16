package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class signUpActivity extends AppCompatActivity {

    Button backButton, signUp;
    TextView haveAnAccount;
    EditText nameInput, emailInput, passwordInput, confirmPasswordInput;
    TextInputLayout passwordInputLayout, confirmPasswordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backButton = findViewById(R.id.signUpBack);
        signUp = findViewById(R.id.signUp);
        nameInput = findViewById(R.id.signUpName);
        emailInput = findViewById(R.id.signUpEmail);
        haveAnAccount = findViewById(R.id.haveAnAccountSignUp);
        passwordInput = findViewById(R.id.signUpPassword);
        confirmPasswordInput = findViewById(R.id.signUpConfirmPassword);
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
                nameInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.bahceden_green));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    nameInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.darkGray));
            }
        });

        //        Text watcher for email Input
        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.bahceden_green));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    emailInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.darkGray));
            }
        });

//        Text Watcher for password Input
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.bahceden_green));
                passwordInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    passwordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.darkGray));
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
                confirmPasswordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.bahceden_green));
                confirmPasswordInputLayout.setEndIconVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    confirmPasswordInput.getCompoundDrawables()[0].setTint(ContextCompat.getColor(signUpActivity.this, R.color.darkGray));
                    confirmPasswordInputLayout.setEndIconVisible(false);
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        haveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUpActivity.this, logInActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpActivity.super.onBackPressed();
            }
        });

    }
}