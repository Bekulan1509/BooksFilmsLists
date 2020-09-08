package com.twodev.booksfilmslists.data.network;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.twodev.booksfilmslists.models.DogImageModel;
import com.twodev.booksfilmslists.models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class DogService {
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dog.ceo/")
            .build();
    DogApi service =  retrofit.create(DogApi.class);


    public void getDogs(DogCallBack callBack) {
        Call<Example> call = service.getDogList();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callBack.onSuccess(response.body());
                    Log.d("tag1", "onResponse: " + response.body().toString());
                } else
                    Log.d("tag1", "onResponse: is null");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                callBack.onFailure(new NetworkErrorException());
                Log.d("tag1", "onFailure:  error");
            }
        });
    }

    public void getDogsImage(DogCallBack callBack){
        Call<DogImageModel> call = service.getDogImage();
        call.enqueue(new Callback<DogImageModel>() {
            @Override
            public void onResponse(Call<DogImageModel> call, Response<DogImageModel> response) {
                if (response.isSuccessful()&&response.body()!=null){
                    callBack.onResponse(response.body());
                    Log.d("image", "onResponse: "+response.body());
                }
                else
                    Log.d("image", "onResponse: is null");
            }

            @Override
            public void onFailure(Call<DogImageModel> call, Throwable t) {
                callBack.onFailure(new NetworkErrorException());
                Log.d("image", "onFailure:  error");
            }
        });
    }


    public interface DogCallBack {
        void onSuccess(Example dog);

        void onResponse(DogImageModel dog);

        void onFailure(Exception exception);
    }

    public interface DogApi {
        @GET("api/breeds/list/all")
        Call<Example> getDogList();

        @GET("api/breeds/image/random")
        Call<DogImageModel> getDogImage();
    }

}
