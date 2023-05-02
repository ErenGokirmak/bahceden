package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.swifties.bahceden.CustomerAddressesActivity;
import com.swifties.bahceden.CustomerAnalyticsActivity;
import com.swifties.bahceden.CustomerCardsActivity;
import com.swifties.bahceden.CustomerEditProfileActivity;
import com.swifties.bahceden.CustomerOrdersActivity;
import com.swifties.bahceden.R;
import com.swifties.bahceden.SecurityProfileActivity;

public class CustomerProfileFragment extends Fragment {

    LinearLayout editProfileButton;
    LinearLayout myOrdersButton;
    LinearLayout addressesButton;
    LinearLayout paymentMethodsButton;
    LinearLayout analyticsButton;
    LinearLayout securityButton;
    LinearLayout logOutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_profile, container, false);

        // Initializing buttons
        editProfileButton = view.findViewById(R.id.customerProfileEditProfileButton);
        myOrdersButton = view.findViewById(R.id.customerProfileMyOrdersButton);
        addressesButton = view.findViewById(R.id.customerProfileAddressesButton);
        paymentMethodsButton = view.findViewById(R.id.customerProfilePaymentMethodsButton);
        analyticsButton = view.findViewById(R.id.customerProfileAnalyticsButton);
        securityButton = view.findViewById(R.id.customerProfileSecurityButton);
        logOutButton = view.findViewById(R.id.customerProfileLogOutButton);

        // Initializing listeners
        // TODO: Edit Profile button doesn't work for some reason.
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerEditProfileActivity.class);
                startActivity(intent);
            }
        });
        myOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerOrdersActivity.class);
                startActivity(intent);
            }
        });

        addressesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerAddressesActivity.class);
                startActivity(intent);
            }
        });

        paymentMethodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerCardsActivity.class);
                startActivity(intent);
            }
        });

        analyticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        securityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecurityProfileActivity.class);
                startActivity(intent);
            }
        });

        // TODO: Log Out button doesn't do anything right now since we're not logged in.

        return view;
    }
}