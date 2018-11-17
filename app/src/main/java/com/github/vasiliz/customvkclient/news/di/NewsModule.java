package com.github.vasiliz.customvkclient.news.di;

import android.support.v4.widget.SwipeRefreshLayout;

import com.github.vasiliz.customvkclient.api.NewsApiClient;
import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.lib.base.ImageLoader;
import com.github.vasiliz.customvkclient.news.NewsInteractor;
import com.github.vasiliz.customvkclient.news.NewsInteractorImpl;
import com.github.vasiliz.customvkclient.news.NewsPresenter;
import com.github.vasiliz.customvkclient.news.NewsPresenterImpl;
import com.github.vasiliz.customvkclient.news.NewsRepository;
import com.github.vasiliz.customvkclient.news.NewsRepositoryImpl;
import com.github.vasiliz.customvkclient.news.adapters.NewsAdapter;
import com.github.vasiliz.customvkclient.news.adapters.OnItemClickListener;
import com.github.vasiliz.customvkclient.entities.Items;
import com.github.vasiliz.customvkclient.news.ui.NewsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    private NewsView mNewsView;
    private OnItemClickListener mOnItemClickListener;
    private SwipeRefreshLayout.OnRefreshListener mSwipeRefreshLayout;

    public NewsModule(NewsView pNewsView, OnItemClickListener pOnItemClickListener) {
        mNewsView = pNewsView;
        mOnItemClickListener = pOnItemClickListener;
    }

    @Singleton
    @Provides
    NewsPresenter providesNewsPresenter(NewsView pNewsView, EventBus pEventBus, NewsInteractor pNewsInteractor) {
        return new NewsPresenterImpl(pNewsView, pEventBus, pNewsInteractor);
    }
    @Singleton
    @Provides
    NewsView providesNewsView(){
        return mNewsView;
    }

    @Singleton
    @Provides
    NewsInteractor providesNewsInteractor(NewsRepository pNewsRepository) {
        return new NewsInteractorImpl(pNewsRepository);
    }

    @Singleton
    @Provides
    NewsRepository providesNewsRepository(EventBus pEventBus, NewsApiClient pNewsApiClient) {
        return new NewsRepositoryImpl(pEventBus, pNewsApiClient);
    }

    @Singleton
    @Provides
    NewsApiClient providesNewsApiClient() {
        return new NewsApiClient();
    }

    @Singleton
    @Provides
    NewsAdapter providesNewsAdapter(List<Items> pItemsList, OnItemClickListener pOnItemClickListener, ImageLoader pImageLoader){
        return new NewsAdapter(pItemsList, pOnItemClickListener, pImageLoader);
    }

    @Singleton
    @Provides
    OnItemClickListener providesOnItemClickListener(){
        return mOnItemClickListener;
    }

    @Singleton
    @Provides
    List<Items> privideItemsList(){
        return new ArrayList<>();
    }

}
