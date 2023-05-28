package com.swifties.bahceden.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.swifties.bahceden.R;
import com.swifties.bahceden.databinding.ActivityCustomerAnalyticsBinding;

import java.util.ArrayList;

public class CustomerAnalyticsActivity extends AppCompatActivity {


    private ImageView backButton;
    private PieChart consumerChart;
    private ActivityCustomerAnalyticsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerAnalyticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customerAnalyticsBackButton.setOnClickListener(view -> CustomerAnalyticsActivity.super.onBackPressed());
        Toast.makeText(this, "AFAIK this page won't exist", Toast.LENGTH_SHORT).show();

        consumerChart = binding.customerAnalyticsConsumerChart;

        ArrayList<PieEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new PieEntry(10, "Benefits"));
        dataEntries.add(new PieEntry(200, "Costs"));

        PieDataSet pieDataSet = new PieDataSet(dataEntries, "Monthly Data");
        pieDataSet.setColors(getResources().getColor(R.color.plus_green, null), getResources().getColor(R.color.minus_red, null));
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(16);

        PieData pieData = new PieData(pieDataSet);

        consumerChart.setData(pieData);
        consumerChart.setCenterText("Monthly Data");
        consumerChart.getDescription().setEnabled(false);
        consumerChart.animate();
    }

}