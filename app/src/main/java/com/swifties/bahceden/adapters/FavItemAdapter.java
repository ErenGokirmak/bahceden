package com.swifties.bahceden.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.databinding.LayoutCustomerFavoritesItemBinding;
import com.swifties.bahceden.models.Product;

import java.util.List;

public class FavItemAdapter extends RecyclerView.Adapter<FavItemAdapter.ViewHolder> {

    List<Product> products;
    Context context;
    LayoutInflater inflater;



    public FavItemAdapter(List<Product> products, Context context, LayoutInflater layoutInflater) {
        this.products = products;
        this.context = context;
        this.inflater = layoutInflater;
    }

    @NonNull
    @Override
    public FavItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCustomerFavoritesItemBinding binding = LayoutCustomerFavoritesItemBinding.inflate(inflater, parent, false);
        return new FavItemAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavItemAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);
        Picasso.get()
                .load(product.getImageURL())
                .into(holder.binding.cartProductImage);
        holder.binding.favoritesProductName.setText(product.getName());
        holder.binding.price.setText(String.format(context.getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit())));
        holder.binding.city.setText(product.getProducer().getCity());
        holder.binding.favButton.setOnClickListener(v -> {
            if (AuthUser.getCustomer().removeFavProduct(product))
            {
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        LayoutCustomerFavoritesItemBinding binding;
        public ViewHolder(LayoutCustomerFavoritesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
