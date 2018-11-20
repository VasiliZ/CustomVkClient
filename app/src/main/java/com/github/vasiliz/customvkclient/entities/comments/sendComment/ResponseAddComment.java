package com.github.vasiliz.customvkclient.entities.comments.sendComment;

import com.google.gson.annotations.SerializedName;

public class ResponseAddComment {

    @SerializedName("comment_id")
    private long mLong;

    public ResponseAddComment() {
    }

    public long getLong() {
        return mLong;
    }

    public void setLong(long pLong) {
        mLong = pLong;
    }
}
