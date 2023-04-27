package com.swifties.bahceden;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class CustomerAnalyticsActivity extends AppCompatActivity {


    PieChart consumerChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_analytics);

        consumerChart = findViewById(R.id.customerAnalyticsConsumerChart);

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