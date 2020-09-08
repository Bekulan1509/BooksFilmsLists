package com.twodev.booksfilmslists.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.twodev.booksfilmslists.App.App;
import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.data.network.DogService;
import com.twodev.booksfilmslists.models.DogImageModel;
import com.twodev.booksfilmslists.models.Example;

import java.io.BufferedReader;


public class PageFragment2 extends Fragment implements DogService.DogCallBack {
    ImageView dogImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_page5, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dogImageView = view.findViewById(R.id.dog_image_view);
        App.dogService.getDogsImage(this);

        dogImageView.setOnClickListener(view1 -> {
            App.dogService.getDogsImage(this);
        });
    }

    @Override
    public void onSuccess(Example dog) {
        Log.d("TAG", "onResponse: ");

    }

    @Override
    public void onResponse(DogImageModel dog) {
        Log.d("TAG", "onResponse: ");
        Glide.with(this).load(dog.getMessage()).into(dogImageView);
    }

    @Override
    public void onFailure(Exception exception) {
        Log.d("TAG", "onResponse: ");

    }
}