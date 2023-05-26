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
import com.swifties.bahceden.adapters.ProductListingAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.databinding.FragmentCustomerProfileBinding;
import com.swifties.bahceden.databinding.FragmentProducerOrdersBinding;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Order;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProducerOrdersFragment extends Fragment {



    private FragmentProducerOrdersBinding binding;

    private RecyclerView ordersRV;
    private RecyclerView.Adapter<ProducerOrderAdapter.ViewHolder> ordersAdapter;
    List<Order> orders;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProducerOrdersBinding.inflate(inflater, container, false);
//        orders = AuthUser.getProducer().getOrders().stream().filter(order -> order.getStatus() != Order.OrderStatus.IN_CART).collect(Collectors.toList());
        ordersRV = binding.producerOrdersRV;
        ordersAdapter = new ProducerOrderAdapter(orders, getContext(), inflater);
        ordersRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        ordersRV.setAdapter(ordersAdapter);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        RetrofitService.getApi(CustomerApi.class).getCustomerById(1).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                orders = response.body().getOrders();
                ordersAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                throw new RuntimeException(t);
            }
        });
    }
}