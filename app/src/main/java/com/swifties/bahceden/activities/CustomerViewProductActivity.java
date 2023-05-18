package com.swifties.bahceden.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CommentCustomerViewAdapter;
import com.swifties.bahceden.adapters.HotSalesAdapter;
import com.swifties.bahceden.data.ProductApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerViewProductActivity extends AppCompatActivity {

    Intent intent;
    Product product;
    private ImageView backButton;
    private RecyclerView similarItemsRV;
    private RecyclerView.Adapter similarItemsAdapter;
    private RecyclerView.LayoutManager similarItemsLM;
    private TextView productNameText, productRatingText, productDescriptionText;
    private RecyclerView commentsRV;
    private RecyclerView.Adapter commentsAdapter;
    private RecyclerView.LayoutManager commentsLM;
    ImageSlider imageSlider;
    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_product);

        retrofitService = new RetrofitService();

        ProductApi productApi = retrofitService.getRetrofit().create(ProductApi.class);

        intent = getIntent();

        productApi.getProductById(Integer.parseInt(intent.getStringExtra("productId"))).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = (Product) response.body();
                productNameText = findViewById(R.id.customerViewProductItemName);
                productDescriptionText = findViewById(R.id.customerViewProductDescriptionText);
                productRatingText = findViewById(R.id.customerViewProductRatingText);

                productNameText.setText(product.getName());
                productDescriptionText.setText(product.getDescription());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(CustomerViewProductActivity.this, "Didn't work for some reason", Toast.LENGTH_SHORT).show();
                Log.d("debugpurposes", t.getMessage());
            }
        });


        backButton = findViewById(R.id.customerViewProductBackButton);
        backButton.setOnClickListener(view -> CustomerViewProductActivity.super.onBackPressed());

        imageSlider = findViewById(R.id.productSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();


        slideModels.add(new SlideModel(R.drawable.honey1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.honey2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.honey3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        similarItemsRV = findViewById(R.id.itemSimilarItems);
        similarItemsRV.setHasFixedSize(true);
        similarItemsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        similarItemsRV.setLayoutManager(similarItemsLM);
        similarItemsAdapter = new HotSalesAdapter();
        similarItemsRV.setAdapter(similarItemsAdapter);

        commentsRV = findViewById(R.id.commentItems);
        commentsRV.setHasFixedSize(true);
        commentsLM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        commentsRV.setLayoutManager(commentsLM);
        commentsAdapter = new CommentCustomerViewAdapter();
        commentsRV.setAdapter(commentsAdapter);
    }
}