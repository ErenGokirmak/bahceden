package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.swifties.bahceden.activities.CustomerAddressesActivity;
import com.swifties.bahceden.activities.CustomerAnalyticsActivity;
import com.swifties.bahceden.activities.CustomerCardsActivity;
import com.swifties.bahceden.activities.CustomerEditProfileActivity;
import com.swifties.bahceden.activities.CustomerOrdersActivity;
import com.swifties.bahceden.activities.IntroActivity;
import com.swifties.bahceden.activities.ProducerMainActivity;
import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.SecurityProfileActivity;
import com.swifties.bahceden.data.AuthUser;

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
        editProfileButton.setOnClickListener(profileView -> {
            Intent intent = new Intent(getActivity(), CustomerEditProfileActivity.class);
            startActivity(intent);
        });
        myOrdersButton.setOnClickListener(ordersView -> {
            Intent intent = new Intent(getActivity(), CustomerOrdersActivity.class);
            startActivity(intent);
        });

        addressesButton.setOnClickListener(addressesView -> {
            Intent intent = new Intent(getActivity(), CustomerAddressesActivity.class);
            startActivity(intent);
        });

        paymentMethodsButton.setOnClickListener(cardsView -> {
            Intent intent = new Intent(getActivity(), CustomerCardsActivity.class);
            startActivity(intent);
        });

        analyticsButton.setOnClickListener(analyticsView -> {
            Intent intent = new Intent(getActivity(), CustomerAnalyticsActivity.class);
            startActivity(intent);
        });

        securityButton.setOnClickListener(securityView -> {
            Intent intent = new Intent(getActivity(), SecurityProfileActivity.class);
            startActivity(intent);
        });

        logOutButton.setOnClickListener(logOutView -> {
            AuthUser.getInstance().deleteUser();
            Intent intent = new Intent(getActivity(), IntroActivity.class);
            startActivity(intent);
        });

        return view;
    }
}