package com.github.vasiliz.customvkclient.news;

public interface NewsInteractor {
    void execute(String pToken);

    void likePost();
}
