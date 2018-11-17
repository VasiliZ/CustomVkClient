package com.github.vasiliz.customvkclient.api;

import com.github.vasiliz.customvkclient.entities.StartResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("method/newsfeed.get")
    Call<StartResponse> newsFeed(@Query("filters") String pFilters,
                                 @Query("access_token") String pToken,
                                 @Query("v")String pVersion);



}
