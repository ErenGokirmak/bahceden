package com.swifties.bahceden.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;

public class YourAddressesAdapter extends RecyclerView.Adapter<YourAddressesAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_address_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourAddressesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "BaS:" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
