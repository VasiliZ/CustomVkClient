package com.github.vasiliz.customvkclient.login;

import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.login.events.LoginEvent;
import com.github.vasiliz.customvkclient.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {

    private EventBus mEventBus;
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(EventBus pEventBus, LoginView pLoginView, LoginInteractor pLoginInteractor) {
        mEventBus = pEventBus;
        mLoginView = pLoginView;
        mLoginInteractor = pLoginInteractor;
    }

    @Override
    public void onResume() {
        mEventBus.register(this);
    }

    @Override
    public void onPause() {
        mEventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    @Override
    public void getLoginToken(String response) {
        if (mLoginView!=null){
            mLoginView.showProgress();
        }
        mLoginInteractor.execute(response);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent pLoginEvent) {
        String error = pLoginEvent.getError();
        if (mLoginView!=null) {
            mLoginView.hideProgress();
            if (error != null) {
                mLoginView.onError(error);
            } else {
                mLoginView.getToken(pLoginEvent.getResponse());
                mLoginView.navigateToNewsScreen();
            }
        }

    }
}
