package com.swifties.bahceden.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.SpinnerCustomAdapter;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.databinding.FragmentProducerAddProductBinding;
import com.swifties.bahceden.models.Product;
import com.swifties.bahceden.uiclasses.SpinnerCustomItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProducerAddProductFragment extends Fragment {

    Spinner itemCategoriesSpinner;
    Spinner itemSubCategoriesSpinner;
    ArrayList<SpinnerCustomItem> customItems;
    ArrayList<ArrayList<SpinnerCustomItem>> customSubItems;

    EditText productNameField, productDescriptionField, productPriceField, productAvailableAmountField;
    SpinnerCustomAdapter spinnerSubCategoriesAdapter;
    Spinner productUnitTypeSpinner;
    Button addProductButton;
    FragmentProducerAddProductBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProducerAddProductBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        itemSubCategoriesSpinner = binding.addItemSubCategoriesSpinner;
        itemCategoriesSpinner = binding.addItemCategoriesSpinner;

        customItems = getCustomCategoriesList();
        customSubItems = getCustomSubCategoriesList();

        productNameField = binding.nameOfItemField;
        productDescriptionField = binding.descriptionOfItemField;
        productPriceField = binding.addProductPriceOfItemField;
        productAvailableAmountField = binding.availableAmountOfItemField;
        productUnitTypeSpinner = binding.addProductUnitTypeSpinner;

        addProductButton = binding.producerAddProductUpdateButton;

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SpinnerCustomAdapter spinnerCategoriesAdapter = new SpinnerCustomAdapter(requireActivity(), customItems);
        spinnerSubCategoriesAdapter = new SpinnerCustomAdapter(requireActivity(), customSubItems.get(0));

        if (itemCategoriesSpinner != null) {
            itemCategoriesSpinner.setAdapter(spinnerCategoriesAdapter);
        }

        if (itemSubCategoriesSpinner != null) {
            itemSubCategoriesSpinner.setAdapter(spinnerSubCategoriesAdapter);
        }

        itemCategoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item here
                spinnerSubCategoriesAdapter = new SpinnerCustomAdapter(getActivity(), customSubItems.get(position));
                itemSubCategoriesSpinner.setAdapter(spinnerSubCategoriesAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        addProductButton.setOnClickListener(addView -> {
            // TODO: take the product name, description, price, and category (further TODO), and make a new Product object.
            //  afterwards, pass this new product onto the database.

            Product product = new Product();

            if (productNameField.getText().equals("") || productDescriptionField.getText().equals("") || productPriceField.getText().equals("")) {
                Toast.makeText(view.getContext(), "Please input appropriate information to the fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (Double.parseDouble(String.valueOf(productPriceField.getText())) < 0) {
                productPriceField.setError("Please input an appropriate price");
                return;
            }
            product.setName(String.valueOf(productNameField.getText()));
            product.setDescription(String.valueOf(productDescriptionField.getText()));
            product.setPricePerUnit(Double.parseDouble(String.valueOf(productPriceField.getText())));
            product.setAmountInStock(Double.parseDouble(String.valueOf(productAvailableAmountField.getText())));
            // product.setUnitType(); TODO: Spinner should return a UnitType
            // product.setImageURL(); TODO: postimageurl stuff
            // TODO: Categories, image, unitType

            RetrofitService.getApi(ProductApi.class).saveProduct(product).enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    Toast.makeText(view.getContext(), "Product successfully saved", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                    Toast.makeText(view.getContext(), "There was an error saving the product", Toast.LENGTH_SHORT).show();
                    Log.d("debugPurposes", t.getMessage());
                }
            });
        });
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

    private ArrayList<ArrayList<SpinnerCustomItem>> getCustomSubCategoriesList() {
        ArrayList<ArrayList<SpinnerCustomItem>> items = new ArrayList<ArrayList<SpinnerCustomItem>>();
        ArrayList<SpinnerCustomItem> submenu1 = new ArrayList<SpinnerCustomItem>();
        submenu1.add(new SpinnerCustomItem("Milk", 0));
        submenu1.add(new SpinnerCustomItem("Cheese", 0));
        submenu1.add(new SpinnerCustomItem("Yogurt", 0));

        ArrayList<SpinnerCustomItem> submenu2 = new ArrayList<SpinnerCustomItem>();
        submenu2.add(new SpinnerCustomItem("Pepperoni", 0));
        submenu2.add(new SpinnerCustomItem("Ham", 0));
        submenu2.add(new SpinnerCustomItem("Wings", 0));

        ArrayList<SpinnerCustomItem> submenu3 = new ArrayList<SpinnerCustomItem>();
        submenu3.add(new SpinnerCustomItem("Fruits", 0));
        submenu3.add(new SpinnerCustomItem("Eggplant", 0));
        submenu3.add(new SpinnerCustomItem("Tomato", 0));

        ArrayList<SpinnerCustomItem> submenu4 = new ArrayList<SpinnerCustomItem>();
        submenu4.add(new SpinnerCustomItem("Hazelnut", 0));
        submenu4.add(new SpinnerCustomItem("Chestnut", 0));
        submenu4.add(new SpinnerCustomItem("Peanut", 0));

        ArrayList<SpinnerCustomItem> submenu5 = new ArrayList<SpinnerCustomItem>();
        submenu5.add(new SpinnerCustomItem("Bread", 0));
        submenu5.add(new SpinnerCustomItem("Toast", 0));
        submenu5.add(new SpinnerCustomItem("Croissant", 0));

        ArrayList<SpinnerCustomItem> submenu6 = new ArrayList<SpinnerCustomItem>();
        submenu6.add(new SpinnerCustomItem("Honey", 0));
        submenu6.add(new SpinnerCustomItem("Olive Oil", 0));
        submenu6.add(new SpinnerCustomItem("Pekmez", 0));

        items.add(submenu1);
        items.add(submenu2);
        items.add(submenu3);
        items.add(submenu4);
        items.add(submenu5);
        items.add(submenu6);

        return items;
    }
}