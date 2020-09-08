package com.twodev.booksfilmslists.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twodev.booksfilmslists.App.App;
import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.adapters.DogAdapter;
import com.twodev.booksfilmslists.data.network.DogService;
import com.twodev.booksfilmslists.interfaces.OnItemClickListener;
import com.twodev.booksfilmslists.models.DogImageModel;
import com.twodev.booksfilmslists.models.Example;

import java.util.ArrayList;
import java.util.List;


public class PageFragment extends  Fragment  implements OnItemClickListener, DogService.DogCallBack  {

    private RecyclerView recyclerView;
    private DogAdapter dogAdapter;
    private List<String> exampleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_page, container, false);
         return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.dogService.getDogs( this);

        recyclerView = view.findViewById(R.id.recyclerViewDog);
    }

    @Override
    public void onClick(int pos) {

    }

    @Override
    public void onSuccess(Example dog) {
        exampleList = new ArrayList<>();
        exampleList.add(dog.getMessage().getAiredale().toString());
        exampleList.add(dog.getMessage().getBasenji().toString());
        exampleList.add(dog.getMessage().getBeagle().toString());
        exampleList.add(dog.getMessage().getDane().toString());
        exampleList.add(dog.getMessage().getDalmatian().toString());
        exampleList.add(dog.getMessage().getPekinese().toString());
        exampleList.add(dog.getMessage().getMastiff().toString());
        exampleList.add(dog.getMessage().getWeimaraner().toString());
        dogAdapter = new DogAdapter(exampleList,this);
        LinearLayoutManager manager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(dogAdapter);

    }

    @Override
    public void onResponse(DogImageModel dog) {

    }


    @Override
    public void onFailure(Exception exception) {

    }
}