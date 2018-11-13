package com.github.vasiliz.customvkclient;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.login.libs.di.DaggerLoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginModule;
import com.github.vasiliz.customvkclient.login.ui.LoginView;

public class CustomVkClient extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public LoginComponent getLoginComponent(AppCompatActivity pAppCompatActivity, LoginView pLoginView){
        return DaggerLoginComponent.builder()
                .libsModule(new LibsModule(pAppCompatActivity))
                .loginModule(new LoginModule(pLoginView))
                .build();
    }
}
