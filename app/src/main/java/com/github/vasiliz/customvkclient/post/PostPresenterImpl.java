package com.github.vasiliz.customvkclient.post;

import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.post.events.PostEvent;
import com.github.vasiliz.customvkclient.post.ui.PostView;

import org.greenrobot.eventbus.Subscribe;

public class PostPresenterImpl implements PostPresenter {

    private PostInteractor mPostInteractor;
    private PostView mPostView;
    private EventBus mEventBus;

    public PostPresenterImpl(PostInteractor pPostInteractor, PostView pPostView, EventBus pEventBus) {
        mPostInteractor = pPostInteractor;
        mPostView = pPostView;
        mEventBus = pEventBus;
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
        mPostView = null;
    }

    @Override
    public void toWork(int pSourceId, int pPostId) {
        if (mPostView != null) {
            mPostView.showProgress();
        }
        mPostInteractor.execute(pSourceId, pPostId, mPostView.getToken());
    }

    @Override
    public void sendComment(int pSourceId, int pPostId, String pToken, String pMessage) {
        mPostInteractor.sendComment(pSourceId, pPostId, pToken, pMessage);
    }

    @Override
    @Subscribe
    public void onEventMainThread(PostEvent pNewsEvent) {
        String error = pNewsEvent.getpError();
        String myComment = pNewsEvent.getNewComment();
        if (mPostView != null) {
            mPostView.hideProgress();
            if (myComment != null){
                mPostView.setNewComment(myComment);
            }
            if (error != null) {
                mPostView.onError(error);
            } else {
                mPostView.setContent(pNewsEvent.getResponseComment());
            }
        }

    }
}
