package com.swifties.bahceden.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.R;
import com.swifties.bahceden.adapters.ProductListingAdapter;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerHomeFragment extends Fragment {
    private RecyclerView newArrivalsRV;
    private RecyclerView.Adapter<ProductListingAdapter.ViewHolder> arrivalsAdapter;

    private ImageSlider imageSlider;
    RecyclerView.LayoutManager newArrivalsLayoutManager;

    View view;
    List<Product> products;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;
    }

    @Override
    public void onResume() {
        super.onResume();

        imageSlider = view.findViewById(R.id.customerHomeSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        RetrofitService.getApi(ProductApi.class).getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products = response.body();
                for (Product p : products) {
                    slideModels.add(new SlideModel(p.getImageURL(), ScaleTypes.FIT));
                    imageSlider.setImageList(slideModels);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        RetrofitService.getApi(ProductApi.class).getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products = response.body();
                newArrivalsRV = view.findViewById(R.id.customerHomeNewArrivalsRV);
                newArrivalsRV.setHasFixedSize(true);
                newArrivalsLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

                newArrivalsRV.setLayoutManager(newArrivalsLayoutManager);
                arrivalsAdapter = new ProductListingAdapter(products, CustomerHomeFragment.this.getContext());
                newArrivalsRV.setAdapter(arrivalsAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}