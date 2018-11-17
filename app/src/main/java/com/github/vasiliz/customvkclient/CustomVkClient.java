package com.github.vasiliz.customvkclient;

import android.app.Application;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.login.libs.di.DaggerLoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginModule;
import com.github.vasiliz.customvkclient.login.ui.LoginView;
import com.github.vasiliz.customvkclient.news.adapters.OnItemClickListener;
import com.github.vasiliz.customvkclient.news.di.DaggerNewsComponent;
import com.github.vasiliz.customvkclient.news.di.NewsComponent;
import com.github.vasiliz.customvkclient.news.di.NewsModule;
import com.github.vasiliz.customvkclient.news.ui.NewsActivity;
import com.github.vasiliz.customvkclient.news.ui.NewsView;

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

    public NewsComponent getNewsComponent(NewsActivity pNewsActivity, NewsView pNewsView, OnItemClickListener pOnItemClickListener){
        return DaggerNewsComponent.builder()
                .libsModule(new LibsModule(pNewsActivity))
                .newsModule(new NewsModule(pNewsView, pOnItemClickListener))
                .build();
    }
}
