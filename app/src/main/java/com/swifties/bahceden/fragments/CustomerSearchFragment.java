package com.swifties.bahceden.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.SpinnerCustomAdapter;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.uiclasses.SpinnerCustomItem;

import java.util.ArrayList;

public class CustomerSearchFragment extends Fragment {

    ArrayList<String> searchHistoryList = new ArrayList<>();
    PopupWindow searchHistoryPopup;
    RecyclerView productSearchRV;
    Button filtersButton, sortByButton;
    ImageView searchButton;
    EditText searchHistoryEditText;
    LinearLayout filtersMenu;

    SwitchCompat producerSwitch, productSwitch;
    Spinner categorySpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create the RecyclerView and its adapter
        productSearchRV = view.findViewById(R.id.customerSearchResultsRV);
        productSearchRV.setHasFixedSize(false);

        searchButton = view.findViewById(R.id.customerSearchImg);
        filtersButton = view.findViewById(R.id.customerSearchFiltersButton);
        sortByButton = view.findViewById(R.id.customerSearchSortByButton);
        filtersMenu = view.findViewById(R.id.filtersMenu);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchKeyword = String.valueOf(searchHistoryEditText.getText());
                // TODO: Make filters and sort by work, and add them to the request
                //  (probably make filters button into a spinner)

                // TODO:
                //  if ([filter is "products"]
                //      RetrofitService.getApi(ProductApi.class)...
                //  else if ([filter is "producers"])
                //      RetrofitService.getApi(ProducerApi.class)...
                //  else if ([filter is "all"])
                //      List<Producer> producers; (fill this using a request)
                //      List<Product> products; (again, with ta request)
                //      productSearchRV.setAdapter(
            }
        });



        filtersButton.setOnClickListener(v -> {
            if (filtersMenu.getVisibility() == View.GONE) {
                filtersMenu.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop);
                filtersMenu.startAnimation(animation);
            }
            else {
                filtersMenu.setVisibility(View.GONE);
            }
        });

        producerSwitch = view.findViewById(R.id.producerSwitch);
        productSwitch = view.findViewById(R.id.productSwitch);

        producerSwitch.setOnClickListener(v -> {
            productSwitch.setChecked(!productSwitch.isChecked());
        });

        productSwitch.setOnClickListener(v -> {
            producerSwitch.setChecked(!producerSwitch.isChecked());
        });

        categorySpinner = view.findViewById(R.id.searchCategoriesSpinner);
        SpinnerCustomAdapter spinnerAdapter = new SpinnerCustomAdapter(getActivity(), getCustomCategoriesList());
        categorySpinner.setAdapter(spinnerAdapter);

        // Fill the search history list
        fillSearchHistory();

        // Create an adapter for the search history list
        ArrayAdapter<String> searchHistoryAdapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, searchHistoryList);

        // Create a ListView for the search history
        ListView searchHistoryListView = new ListView(requireActivity());
        searchHistoryListView.setAdapter(searchHistoryAdapter);

        // Set a click listener for the search history items
        searchHistoryListView.setOnItemClickListener((parent, view12, position, id) -> {
            String selectedSearchHistory = searchHistoryList.get(position);
            EditText editText = getView().findViewById(R.id.customerSearchEditText);
            editText.setText(selectedSearchHistory);
            searchHistoryPopup.dismiss();
        });

        // Create a ListView for the search history popup
        ListView popupListView = new ListView(requireActivity());
        popupListView.setAdapter(searchHistoryAdapter);
        popupListView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedSearchHistory = searchHistoryList.get(position);
            EditText editText = getView().findViewById(R.id.customerSearchEditText);
            editText.setText(selectedSearchHistory);
            searchHistoryPopup.dismiss();
        });

        // Create a PopupWindow for the search history popup
        searchHistoryPopup = new PopupWindow(popupListView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        searchHistoryPopup.setOutsideTouchable(true);
        searchHistoryPopup.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        // Find the EditText view for the search history
        searchHistoryEditText = view.findViewById(R.id.customerSearchEditText);

        // Set a focus change listener for the search history EditText
        searchHistoryEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                searchHistoryPopup.showAsDropDown(searchHistoryEditText);
            } else {
                searchHistoryPopup.dismiss();
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

    private ArrayList<SpinnerCustomItem> getCustomCategoriesList() {
        ArrayList<SpinnerCustomItem> items = new ArrayList<>();
        items.add(new SpinnerCustomItem("Dairy", R.drawable.ic_dairy_products));
        items.add(new SpinnerCustomItem("Meat", R.drawable.ic_meat));
        items.add(new SpinnerCustomItem("Vegetable", R.drawable.ic_fruit));
        items.add(new SpinnerCustomItem("Nuts", R.drawable.ic_peanut));
        items.add(new SpinnerCustomItem("Bakery", R.drawable.ic_bread));
        items.add(new SpinnerCustomItem("Other", R.drawable.ic_honey));

        return items;
    }
}