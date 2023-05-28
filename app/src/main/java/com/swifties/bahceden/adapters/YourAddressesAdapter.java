package com.swifties.bahceden.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.activities.CustomerAddAddressActivity;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.AddressesApi;
import com.swifties.bahceden.databinding.LayoutCustomerAddressItemBinding;
import com.swifties.bahceden.models.Address;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YourAddressesAdapter extends RecyclerView.Adapter<YourAddressesAdapter.ViewHolder> {

    List<Address> addresses;
    Context context;
    LayoutInflater inflater;

    public YourAddressesAdapter(List<Address> addresses, Context context, LayoutInflater inflater) {
        this.addresses = addresses;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCustomerAddressItemBinding binding = LayoutCustomerAddressItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull YourAddressesAdapter.ViewHolder holder, int position) {
        Address address = addresses.get(position);
        holder.binding.checkoutCustomerAddressTitle.setText(address.getTitle());
        holder.binding.adressText.setText(address.getFullAddress());
        holder.binding.checkoutAddressEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, CustomerAddAddressActivity.class);
            intent.putExtra("address_id", address.getId());
            context.startActivity(intent);
        });
        holder.binding.delete.setOnClickListener(v -> {
            RetrofitService.getApi(AddressesApi.class).deleteAddressById(address.getId()).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LayoutCustomerAddressItemBinding binding;

        public ViewHolder(LayoutCustomerAddressItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
