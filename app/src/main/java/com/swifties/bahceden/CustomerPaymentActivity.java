package com.swifties.bahceden;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.PaymentCardsAdapter;

public class CustomerPaymentActivity extends AppCompatActivity {

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_payment);

        backButton = findViewById(R.id.customerPaymentBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerPaymentActivity.super.onBackPressed();
            }
        });

        RecyclerView paymentCardsRV = findViewById(R.id.customerPaymentCardRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        PaymentCardsAdapter ca = new PaymentCardsAdapter();

        paymentCardsRV.setLayoutManager(lam);
        paymentCardsRV.setAdapter(ca);
    }
}