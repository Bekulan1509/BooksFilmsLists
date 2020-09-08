package com.twodev.booksfilmslists.App;

import android.app.Application;

import com.twodev.booksfilmslists.data.network.DogService;
import com.twodev.booksfilmslists.data.network.GhibliService;


public class App extends Application {

    public static GhibliService ghibliService;
    public static DogService dogService;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
        dogService = new DogService();
    }
}
