package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FavoritesActivity extends AppCompatActivity {
    TextView productTxt, dukkanTxt;
    RecyclerView r;
    RecyclerView.Adapter a;
    RecyclerView.LayoutManager l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        productTxt = findViewById(R.id.favPButton);
        dukkanTxt = findViewById(R.id.favDButton);
        buttonsListener listener = new buttonsListener();
        productTxt.setOnClickListener(listener);
        dukkanTxt.setOnClickListener(listener);
        r = (RecyclerView) findViewById(R.id.favProducts);
        r.setHasFixedSize(true);
        l = new LinearLayoutManager(this);
        r.setLayoutManager(l);
        a = new FavItemAdapter();
        r.setAdapter(a);
    }

    private class buttonsListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.favPButton:

                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.darkGray, productTxt.getContext().getTheme()));
                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.white, dukkanTxt.getContext().getTheme()));
                    findViewById(R.id.favDukkans).setVisibility(View.GONE);
                    findViewById(R.id.favProducts).setVisibility(View.VISIBLE);
                    break;
                case R.id.favDButton:

                    dukkanTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_background, dukkanTxt.getContext().getTheme()));
                    dukkanTxt.setTextColor(getResources().getColor(R.color.darkGray, dukkanTxt.getContext().getTheme()));
                    productTxt.setBackgroundColor(getResources().getColor(R.color.bahceden_green, productTxt.getContext().getTheme()));
                    productTxt.setTextColor(getResources().getColor(R.color.white, productTxt.getContext().getTheme()));
                    findViewById(R.id.favDukkans).setVisibility(View.VISIBLE);
                    findViewById(R.id.favProducts).setVisibility(View.GONE);
                    break;
            }
        }
    }

}