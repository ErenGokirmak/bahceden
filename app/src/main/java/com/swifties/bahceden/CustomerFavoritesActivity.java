package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swifties.bahceden.adapters.FavDukkanAdapter;
import com.swifties.bahceden.adapters.FavItemAdapter;

public class CustomerFavoritesActivity extends AppCompatActivity {
    TextView productTxt, dukkanTxt;
    RecyclerView r1;
    RecyclerView r2;
    RecyclerView.Adapter a1;
    RecyclerView.Adapter a2;
    RecyclerView.LayoutManager l1;
    RecyclerView.LayoutManager l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_favorites);

        productTxt = findViewById(R.id.customerFavoritesProductsButton);
        dukkanTxt = findViewById(R.id.customerFavoritesFavoriteDukkansButton);

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerBottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.customerNavFavorites);
        bottomNavigationView.setOnItemSelectedListener(new CustomerNavBarListener(this));

        buttonsListener listener = new buttonsListener();

        productTxt.setOnClickListener(listener);
        dukkanTxt.setOnClickListener(listener);
        r1 = (RecyclerView) findViewById(R.id.customerFavoritesRV);
        r1.setHasFixedSize(true);
        r2 = (RecyclerView) findViewById(R.id.favDukkans);
        r2.setHasFixedSize(true);
        l1 = new LinearLayoutManager(this);
        l2 = new LinearLayoutManager(this);
        r1.setLayoutManager(l1);
        r2.setLayoutManager(l2);
        a1 = new FavItemAdapter();
        a2 = new FavDukkanAdapter();
        r1.setAdapter(a1);
        r2.setAdapter(a2);
    }

    private class buttonsListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.customerFavoritesProductsButton:

                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.darkGray, productTxt.getContext().getTheme()));
                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.white, dukkanTxt.getContext().getTheme()));
                    findViewById(R.id.favDukkans).setVisibility(View.GONE);
                    findViewById(R.id.customerFavoritesRV).setVisibility(View.VISIBLE);
                    break;
                case R.id.customerFavoritesFavoriteDukkansButton:

                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.darkGray, dukkanTxt.getContext().getTheme()));
                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.white, productTxt.getContext().getTheme()));
                    findViewById(R.id.favDukkans).setVisibility(View.VISIBLE);
                    findViewById(R.id.customerFavoritesRV).setVisibility(View.GONE);
                    break;
            }
        }
    }

}