package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CheckOutActivity extends AppCompatActivity {

    private RecyclerView checkOutRc;
    private CheckOutAdapter checkOutAdapter;
    private RecyclerView.LayoutManager rcLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        checkOutRc = findViewById(R.id.checkOutRV);
        checkOutRc.setHasFixedSize(true);
        rcLayoutManager = new LinearLayoutManager(CheckOutActivity.this);
        checkOutRc.setLayoutManager(rcLayoutManager);
        checkOutAdapter = new CheckOutAdapter();
        checkOutRc.setAdapter(checkOutAdapter);
    }
}