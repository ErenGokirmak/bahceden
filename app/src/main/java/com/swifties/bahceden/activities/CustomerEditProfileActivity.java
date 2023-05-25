package com.swifties.bahceden.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.databinding.ActivityCustomerEditProfileBinding;
import com.swifties.bahceden.models.Customer;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerEditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;

    ActivityCustomerEditProfileBinding binding;
    ActivityResultLauncher<String> getImageFromGallery;

    Uri imageUri;
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
                    imageUri = uri;
                    binding.customerEditProfileImage.setImageURI(uri);
                });
        binding.customerEditImageButton.setOnClickListener(v -> {
            getImageFromGallery.launch("image/*");
        });

        binding.customerEditProfileUpdateProfileButton.setOnClickListener(updateView -> {
            try {
                File file = new File(imageUri.getPath());

                RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part imagePart = MultipartBody.Part.createFormData("image", file.getName(), requestBody);

                RetrofitService.getApi(CustomerApi.class).uploadCustomerImage(AuthUser.getCustomer().getId(), imagePart).enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        AuthUser.getInstance().updateUser();
                        CustomerEditProfileActivity.super.onBackPressed();
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {

                    }
                });
        } catch (Exception e) {
                throw e;
            }
        });
    }
}