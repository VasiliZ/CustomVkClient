package com.github.vasiliz.customvkclient.news;

public interface NewsRepository {
    void getNews(String pToken);

    void like();
}
