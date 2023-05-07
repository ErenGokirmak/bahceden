package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CheckOutAdapter;

public class CustomerCheckOutActivity extends AppCompatActivity {

    private ImageView backButton;
    private RecyclerView checkOutRc;
    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager rcLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_check_out);

        backButton = findViewById(R.id.customerCheckOutBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerCheckOutActivity.super.onBackPressed();
            }
        });

        checkOutRc = findViewById(R.id.customerCheckOutOrdersRV);
        checkOutRc.setHasFixedSize(true);
        rcLayoutManager = new LinearLayoutManager(CustomerCheckOutActivity.this);
        checkOutRc.setLayoutManager(rcLayoutManager);
        checkOutAdapter = new CheckOutAdapter();
        checkOutRc.setAdapter(checkOutAdapter);
    }
}