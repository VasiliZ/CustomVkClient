package com.github.vasiliz.customvkclient.news.events;

import com.github.vasiliz.customvkclient.entities.ResponseNews;

public class NewsEvent {
    private String pError;
    private ResponseNews mResponseNews;

    public String getpError() {
        return pError;
    }

    public void setpError(String pPError) {
        pError = pPError;
    }

    public ResponseNews getResponseNews() {
        return mResponseNews;
    }

    public void setResponseNews(ResponseNews pResponseNews) {
        mResponseNews = pResponseNews;
    }
}
