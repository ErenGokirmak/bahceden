package com.swifties.bahceden;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProducerActivity extends AppCompatActivity {
    private RecyclerView producerRV;
    private RecyclerView.Adapter ProducerAdapter;
    RecyclerView.LayoutManager producerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);

        producerRV = (RecyclerView) findViewById(R.id.producerActivityRecyclerView);
        producerRV.setHasFixedSize(true);
        producerLayoutManager = new GridLayoutManager(this, 3);

        producerRV.setLayoutManager(producerLayoutManager);
        ProducerAdapter = new ProducerAdapter();
        producerRV.setAdapter(ProducerAdapter);
    }
}
