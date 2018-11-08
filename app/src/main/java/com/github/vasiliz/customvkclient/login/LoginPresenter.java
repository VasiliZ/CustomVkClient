package com.github.vasiliz.customvkclient.login;

import com.github.vasiliz.customvkclient.login.events.LoginEvent;

public interface LoginPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getLoginToken(String pResponse);
    void onEventMainThread(LoginEvent pLoginEvent);


}
