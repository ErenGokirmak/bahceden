package com.swifties.bahceden.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.ProducerOrderAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.data.apis.OrderApi;
import com.swifties.bahceden.databinding.FragmentProducerOrdersBinding;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Producer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProducerOrdersFragment extends Fragment {


    private FragmentProducerOrdersBinding binding;
    private List<Order> orders;

    private int orderStatusCounts[];

    private LayoutInflater inflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        binding = FragmentProducerOrdersBinding.inflate(inflater, container, false);
        binding.producerOrdersRV.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orders = new ArrayList<>();
        orderStatusCounts = new int[4];
    }

    @Override
    public void onResume() {
        super.onResume();

        RetrofitService.getApi(OrderApi.class).getOrdersOfProducer(AuthUser.getProducer().getId()).enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                orders.clear();
                assert response.body() != null;
                orders.addAll(response.body());
                orders.forEach(o -> o.getProduct().setProducer(new Producer(AuthUser.getProducer().getId())));
                for (Order order : orders) {
                    orderStatusCounts[order.getStatus().getValue() - 2]++;
                }
                System.out.println(orderStatusCounts[0]);

                int pending = orderStatusCounts[Order.OrderStatus.PENDING.getValue() - 2];
                int ongoing = orderStatusCounts[Order.OrderStatus.ONGOING.getValue() - 2];
                int delivered = orderStatusCounts[Order.OrderStatus.DELIVERED.getValue() - 2];
                int cancelled = orderStatusCounts[Order.OrderStatus.CANCELLED.getValue() - 2];

                binding.producerOrdersPendingCount.setText(String.format("%d", pending));
                binding.producerOrdersOngoingCount.setText(String.format("%d", ongoing));
                binding.producerOrdersDeliveredCount.setText(String.format("%d", delivered));
                binding.producerOrdersCancelledCount.setText(String.format("%d", cancelled));

                binding.producerOrdersRV.setAdapter(new ProducerOrderAdapter(orders, getContext(), inflater));
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                throw new RuntimeException(t);
            }
        });
    }
}