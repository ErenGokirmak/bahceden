package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swifties.bahceden.adapters.CheckOutAdapter;

public class CustomerCheckOutActivity extends AppCompatActivity {

    private RecyclerView checkOutRc;
    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager rcLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_check_out);

        checkOutRc = findViewById(R.id.customerCheckOutOrdersRV);
        checkOutRc.setHasFixedSize(true);
        rcLayoutManager = new LinearLayoutManager(CustomerCheckOutActivity.this);
        checkOutRc.setLayoutManager(rcLayoutManager);
        checkOutAdapter = new CheckOutAdapter();
        checkOutRc.setAdapter(checkOutAdapter);
    }
}