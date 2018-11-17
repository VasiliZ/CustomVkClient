package com.github.vasiliz.customvkclient.news;

import android.util.Log;

import com.github.vasiliz.customvkclient.api.NewsApiClient;
import com.github.vasiliz.customvkclient.entities.ResponseNews;
import com.github.vasiliz.customvkclient.entities.StartResponse;
import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.news.events.NewsEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepositoryImpl implements NewsRepository {

    private EventBus mEventBus;
    private NewsApiClient mNewsApiClientl;
    private static final String VERSION = "5.69";
    private static final String FILTERS = "post";

    public NewsRepositoryImpl(EventBus pEventBus, NewsApiClient pNewsApiClientl) {
        mEventBus = pEventBus;
        mNewsApiClientl = pNewsApiClientl;
    }

    @Override
    public void getNews(final String pToken) {
        mNewsApiClientl.getNews.newsFeed(FILTERS, pToken, VERSION).enqueue(new Callback<StartResponse>() {

            @Override
            public void onResponse(Call<StartResponse> call, Response<StartResponse> response) {
                System.out.println(pToken);
               post(response.body().getResponseNews());

            }

            @Override
            public void onFailure(Call<StartResponse> call, Throwable t) {
                Log.d("count_news", t.getLocalizedMessage());
                post(t.getLocalizedMessage());

            }
        });

    }

    @Override
    public void like() {

    }

    private void post(String pError){
        post(null, pError);
    }
    private void post(ResponseNews pNews){
        post(pNews, null);
    }

    private void post(ResponseNews pItems, String pError){
        NewsEvent newsEvent = new NewsEvent();
        newsEvent.setpError(pError);
        newsEvent.setResponseNews(pItems);
        mEventBus.post(newsEvent);
    }
}
