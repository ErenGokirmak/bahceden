package com.swifties.bahceden.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.activities.ProducerOrderDetailsActivity;
import com.swifties.bahceden.R;

public class ProducerOrderAdapter extends RecyclerView.Adapter<ProducerOrderAdapter.ViewHolder> {

    @NonNull
    @Override
    public ProducerOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_producer_orders_item, parent, false);

        return new ProducerOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProducerOrderAdapter.ViewHolder holder, int position) {
        holder.changeStatusButton.setOnClickListener(v -> {
            holder.changeStatusButtonsHolder.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop);
            holder.changeStatusButtonsHolder.startAnimation(animation);
        });
        holder.changeStatusButtonsHolder.setOnClickListener(v -> holder.changeStatusButtonsHolder.setVisibility(View.GONE));

        holder.detailsButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProducerOrderDetailsActivity.class);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatButton changeStatusButton;
        AppCompatButton detailsButton;
        View changeStatusButtonsHolder;

        View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView =
            changeStatusButton = itemView.findViewById(R.id.changeStatusButton);
            changeStatusButtonsHolder = itemView.findViewById(R.id.changeStatusButtonsHolder);
            detailsButton = itemView.findViewById(R.id.detailsButton);

            itemView.setOnClickListener(v -> Toast.makeText(itemView.getContext(), "BaS:" + getAdapterPosition(), Toast.LENGTH_SHORT).show());
        }
    }
}
