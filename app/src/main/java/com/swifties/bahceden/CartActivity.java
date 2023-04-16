package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartProductsRV;
    private RecyclerView.Adapter cartProductAdapter;
    RecyclerView.LayoutManager cartProductLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartProductsRV = (RecyclerView) findViewById(R.id.cartProductRV);
        cartProductsRV.setHasFixedSize(true);
        cartProductLayoutManager = new LinearLayoutManager(this);

        cartProductsRV.setLayoutManager(cartProductLayoutManager);
        cartProductAdapter = new CartProductAdapter();
        cartProductsRV.setAdapter(cartProductAdapter);
    }
}