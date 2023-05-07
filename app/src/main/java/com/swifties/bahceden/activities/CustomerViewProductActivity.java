package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CommentCustomerViewAdapter;
import com.swifties.bahceden.adapters.HotSalesAdapter;

import java.util.ArrayList;

public class CustomerViewProductActivity extends AppCompatActivity {

    private ImageView backButton;
    private RecyclerView similarItemsRV;
    private RecyclerView.Adapter similarItemsAdapter;
    private RecyclerView.LayoutManager similarItemsLM;

    private RecyclerView commentsRV;
    private RecyclerView.Adapter commentsAdapter;
    private RecyclerView.LayoutManager commentsLM;

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_product);

        backButton = findViewById(R.id.customerViewProductBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerViewProductActivity.super.onBackPressed();
            }
        });

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