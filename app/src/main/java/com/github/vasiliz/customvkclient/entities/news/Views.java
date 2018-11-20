package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Views implements Serializable {
    @SerializedName("views")
    private long mCountViews;

    public Views() {
    }

    public long getCountViews() {
        return mCountViews;
    }

    public void setCountViews(long pCountViews) {
        mCountViews = pCountViews;
    }
}
