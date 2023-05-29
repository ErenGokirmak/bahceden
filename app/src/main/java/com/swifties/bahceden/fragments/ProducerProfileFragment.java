package com.swifties.bahceden.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.activities.IntroActivity;
import com.swifties.bahceden.activities.ProducerAnalyticsActivity;
import com.swifties.bahceden.activities.ProducerEditProfileActivity;
import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.SecurityProfileActivity;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.databinding.FragmentProducerProfileBinding;

public class ProducerProfileFragment extends Fragment {

    LinearLayout editProfileButton;
    LinearLayout analyticsButton;
    LinearLayout securityButton;
    LinearLayout logOutButton;

    FragmentProducerProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProducerProfileBinding.inflate(inflater, container, false);

        binding.producerProfileEditProfileButton.setOnClickListener(editProfileView -> {
            Intent intent = new Intent(getActivity(), ProducerEditProfileActivity.class);
            startActivity(intent);
        });

        binding.producerProfileAnalyticsButton.setOnClickListener(analyticsView -> {
            Intent intent = new Intent(getActivity(), ProducerAnalyticsActivity.class);
            startActivity(intent);
        });

        binding.producerProfileSecurityButton.setOnClickListener(securityView -> {
            Intent intent = new Intent(getActivity(), SecurityProfileActivity.class);
            startActivity(intent);
        });


        binding.producerProfileLogOutButton.setOnClickListener(logOutView -> {
            AuthUser.getInstance().deleteUser(getContext());
            Intent intent = new Intent(getActivity(), IntroActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        Picasso.get().load(AuthUser.getProducer().getProfileImageURL()).into(binding.producerProfileImage);
        binding.producerProfileName.setText(AuthUser.getProducer().getName());
        binding.producerProfileEmail.setText(AuthUser.getProducer().getEmail());
    }
}