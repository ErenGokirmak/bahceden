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
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.databinding.ActivityCustomerAnalyticsBinding;
import com.swifties.bahceden.models.Order;

import java.util.ArrayList;

public class CustomerAnalyticsActivity extends AppCompatActivity {


    private ImageView backButton;
    private PieChart consumerChart;
    private ActivityCustomerAnalyticsBinding binding;
    int marketTotal;
    double bahcedenTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerAnalyticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.customerAnalyticsBackButton.setOnClickListener(view -> CustomerAnalyticsActivity.super.onBackPressed());

        // TODO get the market prices of the customer's orders and calculate the total.
        // TODO set it to marketTotal.

        if (AuthUser.getCustomer().getOrders().stream().anyMatch(o -> o.getStatus() != Order.OrderStatus.IN_CART))
            bahcedenTotal = AuthUser.getCustomer().getOrders().stream().filter(o -> o.getStatus() != Order.OrderStatus.IN_CART).map(Order::getTotalPrice).reduce(Double::sum).get();

        setViews(); // TODO call this after the calculations.
    }

    private void setViews ()
    {
        ArrayList<PieEntry> dataEntries = new ArrayList<>();
        dataEntries.add(new PieEntry((int) (marketTotal - bahcedenTotal), "Benefits"));
        dataEntries.add(new PieEntry((int) bahcedenTotal, "Costs"));

        PieDataSet pieDataSet = new PieDataSet(dataEntries, "Monthly Data");
        pieDataSet.setColors(getResources().getColor(R.color.plus_green, null), getResources().getColor(R.color.minus_red, null));
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(16);
        PieData pieData = new PieData(pieDataSet);

        binding.customerAnalyticsConsumerChart.setData(pieData);
        binding.customerAnalyticsConsumerChart.setCenterText("Monthly Data");
        binding.customerAnalyticsConsumerChart.getDescription().setEnabled(false);
        binding.customerAnalyticsConsumerChart.animate();

        binding.customerAnalyticsBenefitValue.setText(String.valueOf(marketTotal - bahcedenTotal));
        binding.customerAnalyticsCostsValue.setText(String.valueOf(bahcedenTotal));
        binding.totalCostText.setText(String.format(getString(R.string.analytics_text), marketTotal));
    }
}