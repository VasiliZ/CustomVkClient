package com.github.vasiliz.customvkclient.news.di;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.news.NewsPresenter;
import com.github.vasiliz.customvkclient.news.ui.NewsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LibsModule.class, NewsModule.class})
public interface NewsComponent {
    void inject(NewsFragment pNewsFragment);
    NewsPresenter getNewsPresenter();





}
