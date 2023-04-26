package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProducerDataActivity extends AppCompatActivity {

    Spinner customDataCategoriesSpinner;
    Spinner customDataSubCategoriesSpinner;
    ArrayList<SpinnerCustomItem> customItems;
    ArrayList<ArrayList<SpinnerCustomItem>> customSubItems;
    SpinnerCustomAdapter spinnerSubCategoriesAdapter;
    PieChart producerChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_data);

        BottomNavigationView bottomNavigationView = findViewById(R.id.producerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.producerNavData);
        bottomNavigationView.setOnItemSelectedListener(new ProducerNavBarListener(this));

        producerChart = findViewById(R.id.producerDataChart);

        ArrayList<PieEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new PieEntry(70, "Our Recommendation"));
        dataEntries.add(new PieEntry(40, "Other Prices"));

        PieDataSet pieDataSet = new PieDataSet(dataEntries, "Success Rate");
        pieDataSet.setColors(getResources().getColor(R.color.plus_green, null), getResources().getColor(R.color.minus_red, null));
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(16);

        PieData pieData = new PieData(pieDataSet);

        producerChart.setData(pieData);
        producerChart.setCenterText("Success Rate");
        producerChart.getDescription().setEnabled(false);
        producerChart.animate();

        customItems = getCustomCategoriesList();
        customSubItems = getCustomSubCategoriesList();

        customDataCategoriesSpinner = findViewById(R.id.dataCategoriesSpinner);
        customDataSubCategoriesSpinner = findViewById(R.id.dataSubCategoriesSpinner);

        SpinnerCustomAdapter spinnerCategoriesAdapter = new SpinnerCustomAdapter(this, customItems);
        spinnerSubCategoriesAdapter = new SpinnerCustomAdapter(this, customSubItems.get(0));

        if (customDataCategoriesSpinner != null) {
            customDataCategoriesSpinner.setAdapter(spinnerCategoriesAdapter);
        }

        if (customDataSubCategoriesSpinner != null) {
            customDataSubCategoriesSpinner.setAdapter(spinnerSubCategoriesAdapter);
        }

        customDataCategoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item here
                spinnerSubCategoriesAdapter = new SpinnerCustomAdapter(ProducerDataActivity.this, customSubItems.get(position));
                customDataSubCategoriesSpinner.setAdapter(spinnerSubCategoriesAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private ArrayList<SpinnerCustomItem> getCustomCategoriesList() {
        ArrayList<SpinnerCustomItem> items = new ArrayList<>();
        items.add(new SpinnerCustomItem("Dairy", R.drawable.ic_dairy_products));
        items.add(new SpinnerCustomItem("Meat", R.drawable.ic_meat));
        items.add(new SpinnerCustomItem("Vegetable", R.drawable.ic_fruit));
        items.add(new SpinnerCustomItem("Nuts", R.drawable.ic_peanut));
        items.add(new SpinnerCustomItem("Bakery", R.drawable.ic_bread));
        items.add(new SpinnerCustomItem("Other", R.drawable.ic_honey));

        return items;
    }

    private ArrayList<ArrayList<SpinnerCustomItem>> getCustomSubCategoriesList() {
        ArrayList<ArrayList<SpinnerCustomItem>> items = new ArrayList<ArrayList<SpinnerCustomItem>>();
        ArrayList<SpinnerCustomItem> submenu1 = new ArrayList<SpinnerCustomItem>();
        submenu1.add(new SpinnerCustomItem("Milk", 0));
        submenu1.add(new SpinnerCustomItem("Cheese", 0));
        submenu1.add(new SpinnerCustomItem("Yogurt", 0));

        ArrayList<SpinnerCustomItem> submenu2 = new ArrayList<SpinnerCustomItem>();
        submenu2.add(new SpinnerCustomItem("Pepperoni", 0));
        submenu2.add(new SpinnerCustomItem("Ham", 0));
        submenu2.add(new SpinnerCustomItem("Wings", 0));

        ArrayList<SpinnerCustomItem> submenu3 = new ArrayList<SpinnerCustomItem>();
        submenu3.add(new SpinnerCustomItem("Fruits", 0));
        submenu3.add(new SpinnerCustomItem("Eggplant", 0));
        submenu3.add(new SpinnerCustomItem("Tomato", 0));

        ArrayList<SpinnerCustomItem> submenu4 = new ArrayList<SpinnerCustomItem>();
        submenu4.add(new SpinnerCustomItem("Hazelnut", 0));
        submenu4.add(new SpinnerCustomItem("Chestnut", 0));
        submenu4.add(new SpinnerCustomItem("Peanut", 0));

        ArrayList<SpinnerCustomItem> submenu5 = new ArrayList<SpinnerCustomItem>();
        submenu5.add(new SpinnerCustomItem("Bread", 0));
        submenu5.add(new SpinnerCustomItem("Toast", 0));
        submenu5.add(new SpinnerCustomItem("croissant", 0));

        ArrayList<SpinnerCustomItem> submenu6 = new ArrayList<SpinnerCustomItem>();
        submenu6.add(new SpinnerCustomItem("Honey", 0));
        submenu6.add(new SpinnerCustomItem("Olive Oil", 0));
        submenu6.add(new SpinnerCustomItem("Pekmez", 0));

        items.add(submenu1);
        items.add(submenu2);
        items.add(submenu3);
        items.add(submenu4);
        items.add(submenu5);
        items.add(submenu6);

        return items;
    }
}