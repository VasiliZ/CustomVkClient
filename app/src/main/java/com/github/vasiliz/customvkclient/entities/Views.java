package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Views {
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
