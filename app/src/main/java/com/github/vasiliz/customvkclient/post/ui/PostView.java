package com.github.vasiliz.customvkclient.post.ui;

import com.github.vasiliz.customvkclient.entities.comments.ResponseComment;

public interface PostView {

    void showComments();
    void hideComments();
    void showProgress();
    void hideProgress();
    String getToken();
    void setNewComment(String pNewComment);
    void sendComment();
    void onError(String pError);
    void setContent(ResponseComment pResponse);

}
