package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ProducerCreateListingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner customSpinner;
    ArrayList<SpinnerCustomItem> customItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_create_listing);

        customSpinner = findViewById(R.id.addItemSpinner);
        customItems = getCustomList();
        SpinnerCustomAdapter spinnerAdapter = new SpinnerCustomAdapter(this, customItems);

        if (customSpinner != null) {
            customSpinner.setAdapter(spinnerAdapter);
            customSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<SpinnerCustomItem> getCustomList() {
        customItems = new ArrayList<>();
        customItems.add(new SpinnerCustomItem("Dairy", R.drawable.ic_dairy_products));
        customItems.add(new SpinnerCustomItem("Meat", R.drawable.ic_meat));
        customItems.add(new SpinnerCustomItem("Vegetable", R.drawable.ic_fruit));
        customItems.add(new SpinnerCustomItem("Nuts", R.drawable.ic_peanut));
        customItems.add(new SpinnerCustomItem("Bakery", R.drawable.ic_bread));
        customItems.add(new SpinnerCustomItem("Other", R.drawable.ic_honey));

        return customItems;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerCustomItem spinnerCustomItem = (SpinnerCustomItem) parent.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}