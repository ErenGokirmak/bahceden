package com.swifties.bahceden.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.swifties.bahceden.R;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.CartItem;
import com.swifties.bahceden.models.Product;

import java.util.List;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.ViewHolder> {

    Cart cart;
    Context context;

    public CartProductAdapter(Cart cart, Context context) {
        this.cart = cart;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_customer_cart_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.get(position);
        Product product = cartItem.getProduct();
        Glide.with(context).load(product.getImageUrl()).into(holder.cartProductImage);
        holder.cartProductName.setText(product.getName());
        holder.cartProductCity.setText(product.getProducer().getCity());
        holder.cartProductPrice.setText(String.format(context.getString(R.string.turkish_lira), String.valueOf(cartItem.getTotalPrice())));
        holder.cartProductAmount.setText(String.valueOf(cartItem.getAmount()));

        holder.cartProductDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItem.increseAmountBy(-1);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        holder.cartProductIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItem.increseAmountBy(1);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        holder.cartProductDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cartProductImage, cartProductDelete;
        TextView cartProductName, cartProductCity, cartProductPrice, cartProductAmount;
        AppCompatButton cartProductDecrement, cartProductIncrement;

        public ViewHolder(View view) {
            super(view);

            cartProductImage = view.findViewById(R.id.cartProductImage);
            cartProductName = view.findViewById(R.id.cartProductName);
            cartProductCity  = view.findViewById(R.id.cartProductCity);
            cartProductPrice = view.findViewById(R.id.cartProductPrice);
            cartProductAmount = view.findViewById(R.id.cartProductAmount);
            cartProductDecrement = view.findViewById(R.id.cartProductDecrement);
            cartProductIncrement = view.findViewById(R.id.cartProductIncrement);
            cartProductDelete = view.findViewById(R.id.cartProductDelete);
        }
    }
}
