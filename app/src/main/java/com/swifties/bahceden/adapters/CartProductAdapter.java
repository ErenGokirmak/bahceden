package com.swifties.bahceden.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.activities.CustomerViewProductActivity;
import com.swifties.bahceden.data.CartApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Product;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.ViewHolder> {

    Cart cart;
    Context context;
    RetrofitService retrofitService;

    public CartProductAdapter(Cart cart, Context context) {
        this.cart = cart;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_customer_cart_item, viewGroup, false);

        retrofitService = new RetrofitService();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order cartItem = cart.get(position);
        Product product = cartItem.getProduct();
        System.out.println(product.getImageURL());
        Picasso.get()
                .load(product.getImageURL())
                .into(holder.cartProductImage);
        holder.cartProductName.setText(product.getName());
        holder.cartProductPrice.setText(String.format(context.getString(R.string.turkish_lira), String.valueOf(cartItem.getTotalPrice())));
        holder.cartProductAmount.setText(String.valueOf(cartItem.getAmount()));

        holder.cartProductDecrement.setOnClickListener(v -> {
            cartItem.offsetAmountBy(-1);
            notifyItemChanged(holder.getBindingAdapterPosition());
        });

        holder.cartProductIncrement.setOnClickListener(v -> {
            cartItem.offsetAmountBy(1);
            notifyItemChanged(holder.getBindingAdapterPosition());
        });

        holder.cartProductDelete.setOnClickListener(v -> {
            CartApi cartApi = retrofitService.getRetrofit().create(CartApi.class);

            // TODO: customer id implementation

            // This part will be in order after
             /*cartApi.deleteOrderFromCart( ___ , cart.get(holder.getBindingAdapterPosition()).getId()).enqueue(new Callback<Order>() {
                @Override
                public void onResponse(Call<Order> call, Response<Order> response) {
                    // TODO: Move cart.remove(...) to here
                }

                @Override
                public void onFailure(Call<Order> call, Throwable t) {
                    Toast.makeText(v.getContext(), "Removal attempt from cart was unsuccessful", Toast.LENGTH_SHORT).show();
                    Log.d("apiError", t.getMessage());
                }
            });*/

            cart.remove(holder.getBindingAdapterPosition());
            notifyItemRemoved(holder.getBindingAdapterPosition());
        });

        // takes the user to the product page of the order
        holder.cartProductImage.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CustomerViewProductActivity.class);
            intent.putExtra("productId", String.valueOf(product.getId()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cartProductImage, cartProductDelete;
        TextView cartProductName, cartProductPrice, cartProductAmount;
        AppCompatButton cartProductDecrement, cartProductIncrement;

        public ViewHolder(View view) {
            super(view);

            // product information
            cartProductImage = view.findViewById(R.id.cartProductImage);
            cartProductName = view.findViewById(R.id.cartProductName);
            cartProductPrice = view.findViewById(R.id.cartProductPrice);
            cartProductAmount = view.findViewById(R.id.cartProductAmount);

            // buttons
            cartProductDecrement = view.findViewById(R.id.cartProductDecrement);
            cartProductIncrement = view.findViewById(R.id.cartProductIncrement);
            cartProductDelete = view.findViewById(R.id.cartProductDelete);
        }
    }


}
