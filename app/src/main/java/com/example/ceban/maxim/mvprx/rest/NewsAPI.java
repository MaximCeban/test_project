package com.example.ceban.maxim.mvprx.rest;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface NewsAPI {
    @GET("sources")
    rx.Observable<NewsSourcesResponse> getNewsSources();
    @GET("articles")
    rx.Observable<ArticlesResponse> getArticles(@QueryMap Map<String, String> map);
}
