package com.swifties.bahceden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.OrdersAdapter;

public class OrdersProfileActivity extends AppCompatActivity {
    private RecyclerView ordersRV;
    private RecyclerView.Adapter OrdersAdapter;
    RecyclerView.LayoutManager ordersLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_profile);

        ordersRV = (RecyclerView) findViewById(R.id.ordersProfileRecyclerView);
        ordersRV.setHasFixedSize(true);
        ordersLayoutManager = new LinearLayoutManager(this);

        ordersRV.setLayoutManager(ordersLayoutManager);
        OrdersAdapter = new OrdersAdapter();
        ordersRV.setAdapter(OrdersAdapter);
    }
}
