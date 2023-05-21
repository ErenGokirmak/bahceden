package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.swifties.bahceden.activities.CustomerMainActivity;
import com.swifties.bahceden.activities.IntroActivity;
import com.swifties.bahceden.activities.ProducerAnalyticsActivity;
import com.swifties.bahceden.activities.ProducerEditProfileActivity;
import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.SecurityProfileActivity;
import com.swifties.bahceden.data.AuthUser;

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

        editProfileButton.setOnClickListener(editProfileView -> {
            Intent intent = new Intent(getActivity(), ProducerEditProfileActivity.class);
            startActivity(intent);
        });

        analyticsButton.setOnClickListener(analyticsView -> {
            Intent intent = new Intent(getActivity(), ProducerAnalyticsActivity.class);
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