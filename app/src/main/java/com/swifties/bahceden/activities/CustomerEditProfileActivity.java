package com.swifties.bahceden.activities;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.databinding.ActivityCustomerEditProfileBinding;

public class CustomerEditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;

    ActivityCustomerEditProfileBinding binding;
    ActivityResultLauncher<String> getImageFromGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customerEditProfileBackButton.setOnClickListener(backView -> CustomerEditProfileActivity.super.onBackPressed());
        Picasso.get()
                .load(AuthUser.getCustomer().getProfileImageUrl())
                .into(binding.customerEditProfileImage);
        binding.customerEditProfileEditFullName.setText(AuthUser.getCustomer().getName());
        binding.customerEditProfileEditEmail.setText(AuthUser.getCustomer().getEmail());
        getImageFromGallery = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    // Handle the returned Uri
                    binding.customerEditProfileImage.setImageURI(uri);
                });
        binding.customerEditImageButton.setOnClickListener(v -> {
            getImageFromGallery.launch("image/*");
        });

        binding.customerEditProfileUpdateProfileButton.setOnClickListener(updateView -> {
            // TODO: Update the database
        });
    }
}