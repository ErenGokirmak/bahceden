package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.CheckOutAdapter;
import com.swifties.bahceden.data.DBConnection;
import com.swifties.bahceden.models.Cart;
import com.swifties.bahceden.models.Order;
import com.swifties.bahceden.models.PostAction;
import com.swifties.bahceden.models.Product;

public class CustomerCheckOutActivity extends AppCompatActivity {

    private ImageView backButton;
    private RecyclerView checkOutRc;
    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager rcLayoutManager;
    private Cart cart;

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
        cart = new Cart(0);

        Order order1 = new Order(0);
        Product product1 = new Product(1);
        order1.setProduct(product1);
        Order order2 = new Order(1);
        Product product2 = new Product(2);
        order2.setProduct(product2);
        cart.getOrders().add(order1);
        cart.getOrders().add(order2);

        DBConnection.retrieveFromDB(new PostAction() {
            @Override
            public void Action() {
                checkOutRc = findViewById(R.id.customerCheckOutOrdersRV);
                checkOutRc.setHasFixedSize(true);
                rcLayoutManager = new LinearLayoutManager(CustomerCheckOutActivity.this);
                checkOutRc.setLayoutManager(rcLayoutManager);
                checkOutAdapter = new CheckOutAdapter(cart, CustomerCheckOutActivity.this);
                checkOutRc.setAdapter(checkOutAdapter);
            }
        }, product1, product2);
    }
}