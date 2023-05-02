package com.swifties.bahceden;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.adapters.OrdersAdapter;

public class CustomerOrdersActivity extends AppCompatActivity {
    private RecyclerView ordersRV;
    private RecyclerView.Adapter OrdersAdapter;
    RecyclerView.LayoutManager ordersLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_orders);

        ordersRV = (RecyclerView) findViewById(R.id.ordersProfileRV);
        ordersRV.setHasFixedSize(true);
        ordersLayoutManager = new LinearLayoutManager(this);

        ordersRV.setLayoutManager(ordersLayoutManager);
        OrdersAdapter = new OrdersAdapter();
        ordersRV.setAdapter(OrdersAdapter);
    }
}
