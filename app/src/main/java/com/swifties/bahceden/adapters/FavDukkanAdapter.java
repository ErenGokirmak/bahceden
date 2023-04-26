package com.swifties.bahceden.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;

public class FavDukkanAdapter extends RecyclerView.Adapter<FavDukkanAdapter.ViewHolder> {

    @NonNull
    @Override
    public FavDukkanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_producer_item, viewGroup, false);

        return new FavDukkanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavDukkanAdapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 20;
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
