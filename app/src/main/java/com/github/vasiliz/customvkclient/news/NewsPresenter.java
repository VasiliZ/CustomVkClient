package com.github.vasiliz.customvkclient.news;

import com.github.vasiliz.customvkclient.news.events.NewsEvent;

public interface NewsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getNews();
    void likePost();
    void onEventMainThread(NewsEvent pNewsEvent);
}
