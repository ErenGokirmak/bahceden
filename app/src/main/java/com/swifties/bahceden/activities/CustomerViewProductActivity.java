package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CommentCustomerViewAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.databinding.ActivityCustomerViewProductBinding;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Product;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerViewProductActivity extends AppCompatActivity {

    Intent intent;
    Product product;
    int productID;
    int productCount = 0;
    ActivityCustomerViewProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerViewProductBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        // Setting up productApi

        // Getting product from the backend
        intent = getIntent();
        productID = intent.getIntExtra("product_id", 0);

        List<Order> orders = AuthUser.getCustomer().getOrders()
                .stream()
                .filter(o -> o.getStatus() == Order.OrderStatus.IN_CART)
                .filter(o -> o.getProduct().getId() == productID)
                .collect(Collectors.toList());
        if (orders.size() > 0) {
            product = orders.get(0).getProduct();
            productCount = orders.get(0).getAmount();
            setViews();
        } else {
            List<Product> productsFromFav = AuthUser.getCustomer().getFavoriteProducts().stream().filter(p -> p.getId() == productID).collect(Collectors.toList());
            if (productsFromFav.size() > 0)
            {
                product = productsFromFav.get(0);
                setViews();
                binding.favButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite));
            } else {
                RetrofitService.getApi(ProductApi.class).getProductById(productID).enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                        // Getting product & finding appropriate fields
                        product = response.body();

                        // Setting appropriate fields to the product's information
                        setViews();
                        binding.favButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_unfavorite));
                    }

                    @Override
                    public void onFailure(@NonNull Call<Product> call, @NonNull Throwable t) {
                        Toast.makeText(CustomerViewProductActivity.this, "Didn't work for some reason", Toast.LENGTH_SHORT).show();
                        Log.d("debug_purposes", t.getMessage());
                    }
                });
            }
        }

//        binding.customerViewProductBackButton.setOnClickListener(view -> CustomerViewProductActivity.super.onBackPressed());
//        ArrayList<SlideModel> slideModels = new ArrayList<>();
//
//        slideModels.add(new SlideModel(R.drawable.honey1, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.honey2, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.honey3, ScaleTypes.FIT));
//        binding.productSlider.setImageList(slideModels);

        RecyclerView similarItemsRV = binding.itemSimilarItems;
        similarItemsRV.setHasFixedSize(true);
        similarItemsRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //similarItemsAdapter = new ProductListingAdapter(products, this);
        //similarItemsRV.setAdapter(similarItemsAdapter);

        RecyclerView commentsRV = binding.commentItems;
        commentsRV.setHasFixedSize(true);
        commentsRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CommentCustomerViewAdapter commentsAdapter = new CommentCustomerViewAdapter();
        commentsRV.setAdapter(commentsAdapter);
    }

    private void setViews ()
    {
        binding.customerViewProductItemName.setText(product.getName());
        binding.customerViewProductDescriptionText.setText(product.getDescription());
        binding.customerViewProductRatingText.setText(String.valueOf(product.getRating()));
        binding.producerName.setText(product.getProducer().getName());
        binding.producerName.setOnClickListener(v -> {
            Intent intent = new Intent(this, CustomerViewProducerActivity.class);
            intent.putExtra("producer_id", product.getProducer().getId());
            this.startActivity(intent);
        });
        binding.productCount.setText(String.valueOf(productCount));
        Picasso.get().load(product.getImageURL()).into(binding.productImage);
        binding.favButton.setOnClickListener(v -> {
            if (AuthUser.getCustomer().removeFavProduct(product))
            {
                binding.favButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_unfavorite));
            }
            else
            {
                AuthUser.getCustomer().addNewFavProduct(product);
                binding.favButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite));
            }
        });
        binding.decrement.setOnClickListener(v -> {
            if (productCount > 0)
                productCount--;
            binding.productCount.setText(String.valueOf(productCount));
            binding.totalPrice.setText(String.format(getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit() * productCount)));
        });
        binding.increment.setOnClickListener(v -> {
            productCount++;
            binding.productCount.setText(String.valueOf(productCount));
            binding.totalPrice.setText(String.format(getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit() * productCount)));
        });
        binding.addToCart.setOnClickListener(v -> {
            AuthUser.getCustomer().addNewOrder(product, productCount);
            CustomerViewProductActivity.super.onBackPressed();
        });
        binding.customerViewProductBackButton.setOnClickListener(v -> CustomerViewProductActivity.super.onBackPressed());
        binding.totalPrice.setText(String.format(getString(R.string.turkish_lira), String.valueOf(product.getPricePerUnit() * productCount)));
    }
}