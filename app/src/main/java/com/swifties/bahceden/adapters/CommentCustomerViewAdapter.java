package com.swifties.bahceden.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;

public class CommentCustomerViewAdapter extends RecyclerView.Adapter<CommentCustomerViewAdapter.ViewHolder> {
    @NonNull
    @Override
    public CommentCustomerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_customer_view, parent, false);

        return new CommentCustomerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentCustomerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v ->
                    Toast.makeText(itemView.getContext(), "BaS:" + getBindingAdapterPosition(), Toast.LENGTH_SHORT).show());
        }
    }
}
