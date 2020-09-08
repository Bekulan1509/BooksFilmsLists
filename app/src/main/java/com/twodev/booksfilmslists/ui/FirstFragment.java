package com.twodev.booksfilmslists.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twodev.activityes.FilmInfo;
import com.twodev.booksfilmslists.App.App;
import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.data.network.GhibliService;
import com.twodev.booksfilmslists.interfaces.OnItemClickListener;
import com.twodev.booksfilmslists.adapters.FilmAdapter;
import com.twodev.booksfilmslists.models.FilmModel;

import java.util.List;


public class FirstFragment extends Fragment implements OnItemClickListener, GhibliService.GhibliCallBack {

    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;
    private List<FilmModel> filmList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        App.ghibliService.getFilmList("58611129-2dbc-4a81-a72f-77ddfc1b1b49",this);

        recyclerView = view.findViewById(R.id.recyclerViewFilm);

    }


    @Override
    public void onSuccess(List<FilmModel> film) {
        filmList = film;
        filmAdapter = new FilmAdapter(filmList,this);
        LinearLayoutManager manager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(filmAdapter);
        filmAdapter.setOnItemClickListener(pos -> {
            Intent intent = new Intent(getContext(), FilmInfo.class);
            intent.putExtra("key",filmList.get(pos).getId());
            startActivity(intent);
        });
        filmAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResponse(FilmModel film) {

    }

    @Override
    public void onFailure(Exception exception) {

    }

    @Override
    public void onClick(int pos) {

    }
}