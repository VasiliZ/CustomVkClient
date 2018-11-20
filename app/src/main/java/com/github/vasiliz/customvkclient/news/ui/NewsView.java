package com.github.vasiliz.customvkclient.news.ui;

import com.github.vasiliz.customvkclient.entities.news.ResponseNews;

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
