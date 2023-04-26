package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swifties.bahceden.adapters.CartProductAdapter;

public class CustomerCartActivity extends AppCompatActivity {

    private RecyclerView cartProductsRV;
    private RecyclerView.Adapter cartProductAdapter;
    RecyclerView.LayoutManager cartProductLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_cart);

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.customerNavCart);
        bottomNavigationView.setOnItemSelectedListener(new CustomerNavBarListener(this));

        cartProductsRV = (RecyclerView) findViewById(R.id.cartProductRV);
        cartProductsRV.setHasFixedSize(true);
        cartProductLayoutManager = new LinearLayoutManager(this);

        cartProductsRV.setLayoutManager(cartProductLayoutManager);
        cartProductAdapter = new CartProductAdapter();
        cartProductsRV.setAdapter(cartProductAdapter);
    }

    public static class ChooseActionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_choose_action, container, false);
        }
    }
}