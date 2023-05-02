package com.swifties.bahceden;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.CardsAdapter;

public class CustomerCardsActivity extends AppCompatActivity {

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_cards);

        backButton = findViewById(R.id.customerCardsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerCardsActivity.super.onBackPressed();
            }
        });

        RecyclerView yourCardsRV = findViewById(R.id.customerCardsYourCardsRV);

        RecyclerView.LayoutManager lam = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        CardsAdapter ca = new CardsAdapter();

        yourCardsRV.setLayoutManager(lam);
        yourCardsRV.setAdapter(ca);
    }
}