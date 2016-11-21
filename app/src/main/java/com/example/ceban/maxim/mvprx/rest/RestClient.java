package com.example.ceban.maxim.mvprx.rest;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public NewsAPI getNewsSources() {
        return createAPIClent().create(NewsAPI.class);
    }

    Retrofit createAPIClent() {
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
}
