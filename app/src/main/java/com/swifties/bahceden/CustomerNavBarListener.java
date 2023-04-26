package com.swifties.bahceden;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class CustomerNavBarListener implements BottomNavigationView.OnItemSelectedListener {

    private Context context;

    public CustomerNavBarListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.customerNavHome:
                intent = new Intent(context, CustomerHomeActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.customerNavSearch:
                intent = new Intent(context, CustomerSearchActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.customerNavCart:
                intent = new Intent(context, CustomerCartActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.customerNavFavorites:
                intent = new Intent(context, CustomerFavoritesActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.customerNavProfile:
                intent = new Intent(context, CustomerProfileActivity.class);
                context.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}