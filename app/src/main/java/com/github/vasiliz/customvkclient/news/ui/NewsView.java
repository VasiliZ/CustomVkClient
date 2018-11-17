package com.github.vasiliz.customvkclient.news.ui;

import com.github.vasiliz.customvkclient.entities.ResponseNews;

import java.util.List;

public interface NewsView {
    void showNews();
    void hideNews();
    void showProgress();
    void hideProgress();
    String getToken();
    void likePost();
    void endRefresh();

    void onError(String pError);
    void setContent(ResponseNews pResponse);

}
