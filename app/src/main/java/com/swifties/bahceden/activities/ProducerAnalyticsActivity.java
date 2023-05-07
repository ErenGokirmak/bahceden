package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.AnalyticsProductAdapter;

public class ProducerAnalyticsActivity extends AppCompatActivity {

    ImageView backButton;
    RecyclerView analyticsProductRV;
    RecyclerView.Adapter analyticsProductAdapter;
    RecyclerView.LayoutManager analyticsProductLM;

    Spinner spinner1;
    Spinner spinner2;

    TextView totalText;
    TextView averageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_analytics);

        backButton = findViewById(R.id.producerAnalyticsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProducerAnalyticsActivity.super.onBackPressed();
            }
        });

        totalText = findViewById(R.id.producerAnalyticsTotalText);
        averageText = findViewById(R.id.producerAnalyticsAverageText);

        analyticsProductRV = (RecyclerView) findViewById(R.id.producerAnalyticsRV);
        analyticsProductRV.setHasFixedSize(true);
        analyticsProductLM = new LinearLayoutManager(this);
        analyticsProductRV.setLayoutManager(analyticsProductLM);
        analyticsProductAdapter = new AnalyticsProductAdapter();
        analyticsProductRV.setAdapter(analyticsProductAdapter);

        spinner1 = (Spinner) findViewById(R.id.producerAnalyticsSpinner1);
        spinner2 = (Spinner) findViewById(R.id.producerAnalyticsSpinner2);

        ArrayAdapter<CharSequence> spinner1Adapter = ArrayAdapter.createFromResource(this, R.array.analytics_spinner_1, android.R.layout.simple_spinner_dropdown_item);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinner1Adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem) {
                    case "This Month":
                        break;
                    case "Last Month":
                        break;
                    case "This Year":
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem) {
                    case "Earnings":
                        totalText.setText("Total : 1500$");
                        averageText.setText("Average : 46$");
                        break;
                    case "Quantity":
                        totalText.setText("Total : 58");
                        averageText.setText("Average : 16");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2 = (Spinner) findViewById(R.id.producerAnalyticsSpinner2);

        ArrayAdapter<CharSequence> spinner2Adapter = ArrayAdapter.createFromResource(this, R.array.analytics_spinner_2, android.R.layout.simple_spinner_dropdown_item);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2Adapter);
    }
}