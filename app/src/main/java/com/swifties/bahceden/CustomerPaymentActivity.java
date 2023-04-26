package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.swifties.bahceden.adapters.CardsAdapter;
import com.swifties.bahceden.adapters.PaymentCardsAdapter;

public class CustomerPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_payment);

        RecyclerView paymentCardsRV = findViewById(R.id.customerPaymentCardRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        PaymentCardsAdapter ca = new PaymentCardsAdapter();

        paymentCardsRV.setLayoutManager(lam);
        paymentCardsRV.setAdapter(ca);
    }
}