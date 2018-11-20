package com.github.vasiliz.customvkclient.post;

public interface PostInteractor {
    void execute(int pSourceId, int pPostId, String pToken);
    void sendComment(int pSourceId, int pPostId, String pToken, String pMessage);

}
