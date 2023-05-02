package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.swifties.bahceden.CustomerEditProfileActivity;
import com.swifties.bahceden.ProducerAnalyticsActivity;
import com.swifties.bahceden.ProducerEditProfileActivity;
import com.swifties.bahceden.R;
import com.swifties.bahceden.SecurityProfileActivity;

import java.security.Security;

public class ProducerProfileFragment extends Fragment {

    LinearLayout editProfileButton;
    LinearLayout analyticsButton;
    LinearLayout securityButton;
    LinearLayout logOutButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producer_profile, container, false);

        editProfileButton = view.findViewById(R.id.producerProfileEditProfileButton);
        analyticsButton = view.findViewById(R.id.producerProfileAnalyticsButton);
        securityButton = view.findViewById(R.id.producerProfileSecurityButton);
        logOutButton = view.findViewById(R.id.producerProfileLogOutButton);

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProducerEditProfileActivity.class);
                startActivity(intent);
            }
        });

        analyticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProducerAnalyticsActivity.class);
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

        // TODO: Log Out Button isn't implemented as we're not logged in at the moment.

        return view;
    }
}