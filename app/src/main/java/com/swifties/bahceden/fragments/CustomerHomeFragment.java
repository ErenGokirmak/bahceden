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
import com.swifties.bahceden.adapters.ProductListingAdapter;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.databinding.FragmentCustomerHomeBinding;
import com.swifties.bahceden.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerHomeFragment extends Fragment {
    private RecyclerView newArrivalsRV;
    private RecyclerView.Adapter<ProductListingAdapter.ViewHolder> arrivalsAdapter;
    private ImageSlider imageSlider;
    private ArrayList<SlideModel> slideModels;
    List<Product> products;
    FragmentCustomerHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCustomerHomeBinding.inflate(inflater, container, false);
        products = new ArrayList<>();

        newArrivalsRV = binding.customerHomeNewArrivalsRV;
        arrivalsAdapter = new ProductListingAdapter(products, getContext(), inflater);

        newArrivalsRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        newArrivalsRV.setAdapter(arrivalsAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Initializing image-slider resources
        imageSlider = binding.customerHomeSlider;
        slideModels = new ArrayList<>();


        RetrofitService.getApi(ProductApi.class).getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                products = response.body();
                arrivalsAdapter.notifyDataSetChanged();
                slideModels.addAll(products.stream().map(p -> new SlideModel(p.getImageURL(), ScaleTypes.FIT)).collect(Collectors.toList()));
                imageSlider.setImageList(slideModels);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


    }
}