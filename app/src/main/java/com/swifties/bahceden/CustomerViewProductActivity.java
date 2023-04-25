package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class CustomerViewProductActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_product);

        imageSlider = findViewById(R.id.productSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();


        slideModels.add(new SlideModel(R.drawable.honey1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.honey2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.honey3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);
    }
}