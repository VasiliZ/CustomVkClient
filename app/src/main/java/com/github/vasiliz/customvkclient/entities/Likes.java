package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Likes {

    @SerializedName("count")
    private long mCountLike;
    @SerializedName("user_likes")
    private int mUserLike;
    @SerializedName("can_like")
    private int mCanLike;

    public Likes() {
    }

    public long getCountLike() {
        return mCountLike;
    }

    public void setCountLike(long pCountLike) {
        mCountLike = pCountLike;
    }

    public int getUserLike() {
        return mUserLike;
    }

    public void setUserLike(int pUserLike) {
        mUserLike = pUserLike;
    }

    public int getCanLike() {
        return mCanLike;
    }

    public void setCanLike(int pCanLike) {
        mCanLike = pCanLike;
    }
}
