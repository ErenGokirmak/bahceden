package com.swifties.bahceden.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.swifties.bahceden.adapters.CommentProducerViewAdapter;
import com.swifties.bahceden.adapters.ProducerHomeNewReviewsAdapter;
import com.swifties.bahceden.adapters.YourListingsAdapter;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CommentApi;
import com.swifties.bahceden.data.apis.ProducerApi;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.databinding.FragmentProducerHomeBinding;
import com.swifties.bahceden.models.Comment;
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
    ArrayList<Comment> comments;
    ArrayList<Product> listings;
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


        // retrieving reviews and listings TODO: Change api requests
        RetrofitService.getApi(CommentApi.class).getAllComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.body() != null) {
                    comments = (ArrayList<Comment>) (response.body());
                    CommentProducerViewAdapter reviewsAdapter = new CommentProducerViewAdapter(comments, getContext());
                    reviewsRV.setAdapter(reviewsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(getContext(), "There was a problem retrieving reviews", Toast.LENGTH_SHORT).show();
                Log.d("debugPurposes", t.getMessage());
            }

        });

        // TODO: Change api requests
        RetrofitService.getApi(ProducerApi.class).getProductsOfProducer(AuthUser.getProducer().getId()).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.body() != null) {
                    listings = (ArrayList<Product>) response.body();
                    YourListingsAdapter yourListingsAdapter = new YourListingsAdapter(listings, getContext());
                    listingsRV.setAdapter(yourListingsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "There was a problem retrieving your listings", Toast.LENGTH_SHORT).show();
                Log.d("debugPurposes", t.getMessage());
            }
        });

        // Image slider
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
        List<Comment> comments = new ArrayList<>();



        RetrofitService.getApi(CommentApi.class).getProducersComments(AuthUser.getProducer().getId()).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                comments.clear();
                comments.addAll(response.body());
                binding.producerHomeNewReviewsRV.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                throw new RuntimeException(t);

            }
        });
        ProducerHomeNewReviewsAdapter producerHomeNewReviewsAdapter = new ProducerHomeNewReviewsAdapter(comments, getContext(), inflater);
        reviewsRV.setAdapter(producerHomeNewReviewsAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}