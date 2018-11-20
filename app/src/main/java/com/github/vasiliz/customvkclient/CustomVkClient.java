package com.github.vasiliz.customvkclient;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.login.libs.di.DaggerLoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginComponent;
import com.github.vasiliz.customvkclient.login.libs.di.LoginModule;
import com.github.vasiliz.customvkclient.login.ui.LoginActivity;
import com.github.vasiliz.customvkclient.login.ui.LoginView;
import com.github.vasiliz.customvkclient.news.adapters.OnItemClickListener;
import com.github.vasiliz.customvkclient.news.di.DaggerNewsComponent;
import com.github.vasiliz.customvkclient.news.di.NewsComponent;
import com.github.vasiliz.customvkclient.news.di.NewsModule;
import com.github.vasiliz.customvkclient.news.ui.NewsView;
import com.github.vasiliz.customvkclient.post.di.DaggerPostComponent;
import com.github.vasiliz.customvkclient.post.di.PostComponent;
import com.github.vasiliz.customvkclient.post.di.PostModule;
import com.github.vasiliz.customvkclient.post.ui.PostActivity;
import com.github.vasiliz.customvkclient.post.ui.PostView;

public class CustomVkClient extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public LoginComponent getLoginComponent(LoginActivity pLoginActivity, LoginView pLoginView){
        return DaggerLoginComponent.builder()
                .libsModule(new LibsModule(pLoginActivity))
                .loginModule(new LoginModule(pLoginView))
                .build();
    }

    public NewsComponent getNewsComponent(NewsView pNewsView, OnItemClickListener pOnItemClickListener){
        return DaggerNewsComponent.builder()
                .libsModule(new LibsModule(null))
                .newsModule(new NewsModule(pNewsView, pOnItemClickListener))
                .build();
    }
    public PostComponent getPostComponent(PostActivity pPostActivity){
        return DaggerPostComponent.builder()
                .libsModule(new LibsModule(null))
                .postModule(new PostModule(pPostActivity))
                .build();
    }
}
