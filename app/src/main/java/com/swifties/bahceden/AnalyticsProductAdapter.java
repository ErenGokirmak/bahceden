package com.swifties.bahceden;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnalyticsProductAdapter extends RecyclerView.Adapter<AnalyticsProductAdapter.ViewHolder> {
    @NonNull
    @Override
    public AnalyticsProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent).inflate(R.layout.analytics_product_item, parent, false);

        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull AnalyticsProductAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
        }
    }
}
