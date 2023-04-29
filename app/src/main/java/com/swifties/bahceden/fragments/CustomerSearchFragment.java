package com.swifties.bahceden.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.swifties.bahceden.R;

import java.util.ArrayList;

public class CustomerSearchFragment extends Fragment {

    ArrayList<String> searchHistoryList = new ArrayList<>();
    PopupWindow searchHistoryPopup;

    EditText searchHistoryEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fill the search history list
        fillSearchHistory();

        // Create an adapter for the search history list
        ArrayAdapter<String> searchHistoryAdapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, searchHistoryList);

        // Create a ListView for the search history
        ListView searchHistoryListView = new ListView(requireActivity());
        searchHistoryListView.setAdapter(searchHistoryAdapter);

        // Set a click listener for the search history items
        searchHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSearchHistory = searchHistoryList.get(position);
                EditText editText = getView().findViewById(R.id.customerSearchHistoryEditText);
                editText.setText(selectedSearchHistory);
                searchHistoryPopup.dismiss();
            }
        });

        // Create a ListView for the search history popup
        ListView popupListView = new ListView(requireActivity());
        popupListView.setAdapter(searchHistoryAdapter);
        popupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSearchHistory = searchHistoryList.get(position);
                EditText editText = getView().findViewById(R.id.customerSearchHistoryEditText);
                editText.setText(selectedSearchHistory);
                searchHistoryPopup.dismiss();
            }
        });

        // Create a PopupWindow for the search history popup
        searchHistoryPopup = new PopupWindow(popupListView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        searchHistoryPopup.setOutsideTouchable(true);
        searchHistoryPopup.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        // Find the EditText view for the search history
        searchHistoryEditText = view.findViewById(R.id.customerSearchHistoryEditText);

        // Set a focus change listener for the search history EditText
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

//        // Set a touch listener for the parent layout
//        ViewGroup parentLayout = view.findViewById(android.R.id.content);
//        parentLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    // Remove focus from the EditText
//                    InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(searchHistoryEditText.getWindowToken(), 0);
//                    searchHistoryEditText.clearFocus();
//                    // Dismiss the PopupWindow
//                    searchHistoryPopup.dismiss();
//                    return true;
//                }
//                return false;
//            }
//        });
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