package com.twodev.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.twodev.booksfilmslists.App.App;
import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.data.network.GhibliService;
import com.twodev.booksfilmslists.models.FilmModel;

import java.util.List;

public class FilmInfo extends AppCompatActivity implements GhibliService.GhibliCallBack {

    private TextView filmName;
    private TextView filmDeck;
    private TextView filmDirector;
    private TextView filmProducer;
    private TextView filmReleaseDate;
    private TextView filmScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);
        String id = getIntent().getStringExtra("key");
        App.ghibliService.getFilmById(id,  this);
        filmName = findViewById(R.id.info_filmName);
        filmDeck = findViewById(R.id.info_desc);
        filmDirector = findViewById(R.id.info_director);
        filmProducer = findViewById(R.id.info_producer);
        filmReleaseDate = findViewById(R.id.info_releaseDate);
        filmScore = findViewById(R.id.info_rtScore);

    }

    @Override
    public void onSuccess(List<FilmModel> film) {

    }

    @Override
    public void onResponse(FilmModel film) {
        filmName.setText(film.getTitle());
        filmDeck.setText(film.getDescription());
        filmDirector.setText(film.getDirector());
        filmProducer.setText(film.getProducer());
        filmReleaseDate.setText(film.getReleaseDate());
        filmScore.setText(film.getRtScore());
    }

    @Override
    public void onFailure(Exception exception) {

    }
}