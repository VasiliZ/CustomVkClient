package com.github.vasiliz.customvkclient.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsClient {

    static Gson mGson = new GsonBuilder()
            .setLenient()
            .create();

    public static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl("https://api.vk.com")
            .addConverterFactory(GsonConverterFactory.create(mGson))
            .build();

    public CommentService getNews = RETROFIT.create(CommentService.class);

}
