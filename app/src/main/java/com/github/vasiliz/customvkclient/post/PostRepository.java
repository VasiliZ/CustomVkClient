package com.github.vasiliz.customvkclient.post;

public interface PostRepository {
    void getComments(int pSourceId, int pPostId, String pToken);
    void sendComment(int pSourceId, int pPostId, String pToken, String pMessage);

}
