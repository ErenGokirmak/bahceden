package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;
import com.swifties.bahceden.R;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.AddressesApi;
import com.swifties.bahceden.models.Address;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerAddAddressActivity extends AppCompatActivity {

    private ImageView backButton;
    private EditText addressNameField, fullAddressField, phoneNumberField;
    private CountryCodePicker countryCodePicker;
    private Button addAddressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_address);

        // Back button and listener initialization
        backButton = findViewById(R.id.customerAddAddressBackButton);
        backButton.setOnClickListener(backView -> CustomerAddAddressActivity.super.onBackPressed());

        // Fields
        addressNameField = findViewById(R.id.customerAddAddressEditTitleOfAddress);
        fullAddressField = findViewById(R.id.customerAddAddressEditFullAddress);

        // Phone number
        phoneNumberField = findViewById(R.id.customerAddAddressEditPhoneNumber);
        countryCodePicker = findViewById(R.id.customerAddAddressEditCountryCode);

        // Add Address Button
        addAddressButton = findViewById(R.id.customerAddAddressButton);
        addAddressButton.setOnClickListener(addAddressView -> {

            String addressName = String.valueOf(addressNameField.getText());
            String fullAddress = String.valueOf(fullAddressField.getText());
            String phoneNumber = String.valueOf(countryCodePicker.getFullNumber() + phoneNumberField.getText());

            // Check if any field is empty
            if (!addressName.equals("") && !fullAddress.equals("") && !phoneNumber.equals("")) {
                Address newAddress = new Address(addressName, fullAddress, phoneNumber, AuthUser.getCustomer());
                RetrofitService.getApi(AddressesApi.class).saveAddress(newAddress).enqueue(new Callback<Address>() {
                    @Override
                    public void onResponse(@NonNull Call<Address> call, @NonNull Response<Address> response) {
                        assert response.body() != null;
                        if (response.body().equals(newAddress)) {
                            Toast.makeText(CustomerAddAddressActivity.this,
                                    "successful", Toast.LENGTH_SHORT).show();
                            AuthUser.getInstance().updateUser();
                        }
                    }

                    @Override
                    public void onFailure(Call<Address> call, Throwable t) {
                        Toast.makeText(CustomerAddAddressActivity.this,
                                "There was a problem adding the new address", Toast.LENGTH_SHORT).show();
                        Log.d("debug",
                                "There was a problem adding the new address " + t.getMessage());
                    }
                });
            }
        });

    }
}