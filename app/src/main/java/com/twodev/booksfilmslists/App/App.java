package com.twodev.booksfilmslists.App;

import android.app.Application;

import com.twodev.booksfilmslists.data.network.GhibliService;

import retrofit2.Retrofit;

public class App extends Application {

    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
    }
}
