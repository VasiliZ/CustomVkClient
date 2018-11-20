package com.github.vasiliz.customvkclient.post;

import com.github.vasiliz.customvkclient.post.events.PostEvent;

public interface PostPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void toWork(int pSourceId, int pPostId);
    void sendComment(int pSourceId, int pPostId,String pToken, String pMessage);
    void onEventMainThread(PostEvent pNewsEvent);

}
