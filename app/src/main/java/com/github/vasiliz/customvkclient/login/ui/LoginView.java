package com.github.vasiliz.customvkclient.login.ui;

public interface LoginView {
    void showProgress();
    void hideProgress();

    void onError(String error);
    void getToken(String token);
    void navigateToNewsScreen();


}
