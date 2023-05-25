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
import com.swifties.bahceden.adapters.CommentProducerViewAdapter;
import com.swifties.bahceden.adapters.YourListingsAdapter;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.databinding.FragmentProducerHomeBinding;
import com.swifties.bahceden.models.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProducerHomeFragment extends Fragment {

    FragmentProducerHomeBinding binding;
    RecyclerView reviewsRV, listingsRV;
    ImageSlider imageSlider;
    ArrayList<Product> productsInSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProducerHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // RecyclerView initializations
        reviewsRV = binding.producerHomeNewReviewsRV;
        listingsRV = binding.producerHomeYourListingsRV;

        reviewsRV.setHasFixedSize(true);
        listingsRV.setHasFixedSize(true);

        // layout managers
        RecyclerView.LayoutManager reviewsLM = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        reviewsRV.setLayoutManager(reviewsLM);
        RecyclerView.LayoutManager listingsLM = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        listingsRV.setLayoutManager(listingsLM);

        // adapters
        CommentProducerViewAdapter reviewsAdapter = new CommentProducerViewAdapter();
        reviewsRV.setAdapter(reviewsAdapter);
        YourListingsAdapter yourListingsAdapter = new YourListingsAdapter();
        listingsRV.setAdapter(yourListingsAdapter);

        // image slider
        imageSlider = binding.producerHomeSlider;
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        // TODO: This will need to be changed to a more appropriate request
        RetrofitService.getApi(ProductApi.class).getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                productsInSlider = new ArrayList<>();
                productsInSlider.addAll(response.body());
                slideModels.addAll(productsInSlider.stream().map(p -> new SlideModel(p.getImageURL(), ScaleTypes.FIT)).collect(Collectors.toList()));
                imageSlider.setImageList(slideModels);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}