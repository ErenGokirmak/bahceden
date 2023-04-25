package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.swifties.bahceden.adapters.CardsAdapter;

public class CustomerCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_cards);

        RecyclerView yourCardsRV = findViewById(R.id.yourCardsRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        CardsAdapter ca = new CardsAdapter();

        yourCardsRV.setLayoutManager(lam);
        yourCardsRV.setAdapter(ca);
    }
}