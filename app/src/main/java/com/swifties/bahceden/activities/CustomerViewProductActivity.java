package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CommentCustomerViewAdapter;
import com.swifties.bahceden.adapters.ProductListingAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.databinding.ActivityCustomerViewProductBinding;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerViewProductActivity extends AppCompatActivity {

    Intent intent;
    Product product;
    int productID;
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
        List<Product> productsFromFav = AuthUser.getCustomer().getFavoriteProducts().stream().filter(p -> p.getId() == productID).collect(Collectors.toList());
        if (productsFromFav.size() > 0)
        {
            product = productsFromFav.get(0);
            setViews();
            binding.favButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite));
        } else {
            List<Product> productsFromOrders = AuthUser.getCustomer().getOrders()
                    .stream().filter(o -> o.getProduct().getId() == productID)
                    .map(Order::getProduct).collect(Collectors.toList());
            if (productsFromOrders.size() > 0) {
                product = productsFromOrders.get(0);
                setViews();
            } else
            {
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
    }
}