package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Comments {
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
