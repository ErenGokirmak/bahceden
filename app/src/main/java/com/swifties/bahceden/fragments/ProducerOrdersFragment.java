package com.swifties.bahceden.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.ProducerOrderAdapter;
import com.swifties.bahceden.databinding.FragmentCustomerProfileBinding;
import com.swifties.bahceden.databinding.FragmentProducerOrdersBinding;

public class ProducerOrdersFragment extends Fragment {

    private RecyclerView producerOrdersRV;
    private ProducerOrderAdapter producerOrderAdapter;
    private RecyclerView.LayoutManager producerOrderLM;

    private FragmentProducerOrdersBinding binding;

    private AppCompatButton changeStatus;

    private AppCompatButton detailsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProducerOrdersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return inflater.inflate(R.layout.fragment_producer_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}