package com.example.ceban.maxim.mvprx.rest;


import com.example.ceban.maxim.mvprx.entities.Source;

import retrofit2.http.GET;


/**
 *
 */

public interface NewsAPI {
    @GET("sources")
    rx.Observable<NewsSourcesResponse> getNewsSources();

}
