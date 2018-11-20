package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

public class StartResponse {
    @SerializedName("response")
    private ResponseNews mResponseNews;

    public StartResponse() {
    }

    public ResponseNews getResponseNews() {
        return mResponseNews;
    }

    public void setResponseNews(ResponseNews pResponseNews) {
        mResponseNews = pResponseNews;
    }
}
