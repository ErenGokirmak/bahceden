package com.swifties.bahceden;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProducerNavBarListener implements BottomNavigationView.OnItemSelectedListener{

    private Context context;

    public ProducerNavBarListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.producerNavHome:
                intent = new Intent(context, ProducerHomeActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.producerNavSearch:
                intent = new Intent(context, ProducerSearchActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.producerNavAdd:
                intent = new Intent(context, ProducerCreateListingActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.producerNavData:
                intent = new Intent(context, ProducerDataActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.producerNavProfile:
                intent = new Intent(context, ProducerProfileActivity.class);
                context.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
