package com.swifties.bahceden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ProducerSearchActivity extends AppCompatActivity {

    ArrayList<String> searchHistoryList = new ArrayList<>();
    PopupWindow searchHistoryPopup;

    EditText searchHistoryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_search);

        fillSearchHistory();

        ArrayAdapter<String> searchHistoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchHistoryList);

        ListView searchHistoryListView = new ListView(this);
        searchHistoryListView.setAdapter(searchHistoryAdapter);

        searchHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSearchHistory = searchHistoryList.get(position);
                EditText editText = findViewById(R.id.producerSearchHistoryEditText);
                editText.setText(selectedSearchHistory);
                searchHistoryPopup.dismiss();
            }
        });

        ListView popupListView = new ListView(this);
        popupListView.setAdapter(searchHistoryAdapter);
        popupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSearchHistory = searchHistoryList.get(position);
                EditText editText = findViewById(R.id.customerSearchHistoryEditText);
                editText.setText(selectedSearchHistory);
                searchHistoryPopup.dismiss();
            }
        });

        searchHistoryPopup = new PopupWindow(popupListView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        searchHistoryPopup.setOutsideTouchable(true);
        searchHistoryPopup.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        searchHistoryEditText = findViewById(R.id.producerSearchHistoryEditText);

        searchHistoryEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    searchHistoryPopup.showAsDropDown(searchHistoryEditText);
                } else {
                    searchHistoryPopup.dismiss();
                }
            }
        });

        ViewGroup parentLayout = findViewById(android.R.id.content);
        parentLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Remove focus from the EditText
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(searchHistoryEditText.getWindowToken(), 0);
                    searchHistoryEditText.clearFocus();
                    // Dismiss the PopupWindow
                    searchHistoryPopup.dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    private void fillSearchHistory() {
        searchHistoryList.add("Milk");
        searchHistoryList.add("Pink Milk");
        searchHistoryList.add("Meat");
        searchHistoryList.add("Honey");
        searchHistoryList.add("Şifa Gıda");
        searchHistoryList.add("Herbs");
    }
}