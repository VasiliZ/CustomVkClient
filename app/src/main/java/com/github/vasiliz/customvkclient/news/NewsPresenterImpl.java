package com.github.vasiliz.customvkclient.news;

import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.news.events.NewsEvent;
import com.github.vasiliz.customvkclient.news.ui.NewsView;

import org.greenrobot.eventbus.Subscribe;

public class NewsPresenterImpl implements NewsPresenter {
    private NewsView mNewsView;
    private EventBus mEventBus;
    private NewsInteractor mNewsInteractor;

    public NewsPresenterImpl(NewsView pNewsView, EventBus pEventBus, NewsInteractor pNewsInteractor) {
        mNewsView = pNewsView;
        mEventBus = pEventBus;
        mNewsInteractor = pNewsInteractor;
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
        mNewsView = null;
    }

    @Override
    public void getNews() {
        if (mNewsView != null){
            mNewsView.hideNews();
            mNewsView.showProgress();
        }
        mNewsInteractor.execute(mNewsView.getToken());

    }

    @Override
    public void likePost() {
        mNewsInteractor.likePost();
    }

    @Override
    @Subscribe
    public void onEventMainThread(NewsEvent pNewsEvent) {
        String errorMsg = pNewsEvent.getpError();
        if (mNewsView != null){
            mNewsView.showNews();
            mNewsView.hideProgress();
            mNewsView.endRefresh();
            if (errorMsg != null){
                mNewsView.onError(errorMsg);
            }else {
                mNewsView.setContent(pNewsEvent.getResponseNews());
            }
        }

    }
}
