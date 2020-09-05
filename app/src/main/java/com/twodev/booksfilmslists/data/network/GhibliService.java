package com.twodev.booksfilmslists.data.network;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.twodev.booksfilmslists.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .build();
    GhibliApi service = retrofit.create(GhibliApi.class);


    public void getFilmById(String id , GhibliCallBack callBack){
        Call<FilmModel> call = service.getFilmById(id);
        call.enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful() && response.body()!=null){
                    callBack.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                callBack.onFailure(new NetworkErrorException());
            }
        });
    }


    public void getFilmList(String s, GhibliCallBack ghibliCallBack) {
        Call<List<FilmModel>> call = service.getFilmList();
        call.enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){

                        ghibliCallBack.onSuccess(response.body());

                        Log.d("tag", response.body().toString());
                    }else
                        Log.d("tag", "response body is null ");
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                ghibliCallBack.onFailure(new NetworkErrorException());
                Log.d("tag", "ERROR ");

            }
        });
    }
    public interface GhibliCallBack{
        void onSuccess(List<FilmModel> film);
        void onResponse(FilmModel film);
        void onFailure(Exception exception);
    }

    public interface GhibliApi {
        @GET("films")
        Call<List<FilmModel>> getFilmList();

        @GET("films/{id}")
        Call<FilmModel> getFilmById(@Path("id") String filmId);

    }
}
