package com.swifties.bahceden.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.databinding.LayoutItemBinding;

import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Product;

import java.util.List;

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.ViewHolder> {

    List<Product> products;
    Context context;
    LayoutInflater inflater;
    public ProductListingAdapter(List<Product> products, Context context, LayoutInflater inflater) {
        this.products = products;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutItemBinding binding = LayoutItemBinding.inflate(inflater, viewGroup, false);
        return new ProductListingAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(holder.getBindingAdapterPosition());
        holder.binding.itemLayoutItemName.setText(product.getName());
        holder.binding.itemLayoutPriceText.setText(String.format(context.getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit())));
        holder.binding.itemLayoutProducerNameText.setText(product.getProducer().getName());
        if (AuthUser.getCustomer().getFavoriteProducts().contains(product))
        {
            Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
            drawable.setTint(context.getResources().getColor(R.color.minus_red));
            holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
        }
        else
        {
            Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
            drawable.setTint(context.getResources().getColor(R.color.white));
            holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
        }
        Picasso.get()
            .load(product.getImageURL())
                .into(holder.binding.itemLayoutItemImage);
        holder.binding.itemLayoutItemLiked.setOnClickListener(v -> {
            if (AuthUser.getCustomer().removeFavProduct(product))
            {
                Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
                drawable.setTint(context.getResources().getColor(R.color.white));
                holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
            }
            else
            {
                AuthUser.getCustomer().addNewFavProduct(product);
                Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
                drawable.setTint(context.getResources().getColor(R.color.minus_red));
                holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
            }
        });

        holder.binding.itemLayoutAddToCart.setOnClickListener(v -> {
            AuthUser.getCustomer().getCart().addProduct(product);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LayoutItemBinding binding;

        public ViewHolder(LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
