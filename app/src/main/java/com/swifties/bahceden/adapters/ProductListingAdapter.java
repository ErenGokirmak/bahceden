package com.swifties.bahceden.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.data.AuthCustomer;
import com.swifties.bahceden.databinding.LayoutItemBinding;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Product;

import java.util.List;

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.ViewHolder> {

    List<Product> products;
    Context context;

    public ProductListingAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item, viewGroup, false);

        return new ViewHolder(view, LayoutItemBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(holder.getBindingAdapterPosition());
        holder.binding.itemLayoutProducerNameText.setText(product.getName());
        holder.binding.itemLayoutPriceText.setText(String.format(context.getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit())));
        holder.binding.itemLayoutProducerNameText.setText(product.getProducer().getName());
        Picasso.get()
            .load(product.getImageURL())
                .into(holder.binding.itemLayoutItemImage);
        holder.binding.itemLayoutItemLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AuthCustomer.getCustomer().getFavoriteProducts().remove(product))
                {
                    Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
                    drawable.setTint(context.getResources().getColor(R.color.white));
                    holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
                }
                else
                {
                    AuthCustomer.getCustomer().getFavoriteProducts().add(product);
                    Drawable drawable = holder.binding.itemLayoutItemLiked.getDrawable();
                    drawable.setTint(context.getResources().getColor(R.color.minus_red));
                    holder.binding.itemLayoutItemLiked.setImageDrawable(drawable);
                }
            }
        });

        holder.binding.itemLayoutAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AuthCustomer.getCustomer().getCart().getOrders().add(//TODO);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LayoutItemBinding binding;

        public ViewHolder(View view, LayoutItemBinding binding) {
            super(view);
            this.binding = binding;
            view.setOnClickListener(v -> Toast.makeText(view.getContext(), "BaS:" + getBindingAdapterPosition(), Toast.LENGTH_SHORT).show());
        }
    }
}
