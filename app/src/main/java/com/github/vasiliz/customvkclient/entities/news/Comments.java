package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comments implements Serializable {
    @SerializedName("count")
    private long mCountComments;
    @SerializedName("can_post")
    private int mCanPost;

    public Comments() {
    }

    public long getCountComments() {
        return mCountComments;
    }

    public void setCountComments(long pCountComments) {
        mCountComments = pCountComments;
    }

    public int getCanPost() {
        return mCanPost;
    }

    public void setCanPost(int pCanPost) {
        mCanPost = pCanPost;
    }
}
