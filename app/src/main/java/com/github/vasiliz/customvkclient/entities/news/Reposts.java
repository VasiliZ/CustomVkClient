package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Reposts implements Serializable {
    @SerializedName("count")
    private long mCountReposts;
    @SerializedName("user_reposted")
    private int mUserReposted;

    public Reposts() {
    }

    public long getCountReposts() {
        return mCountReposts;
    }

    public void setCountReposts(long pCountReposts) {
        mCountReposts = pCountReposts;
    }

    public int getUserReposted() {
        return mUserReposted;
    }

    public void setUserReposted(int pUserReposted) {
        mUserReposted = pUserReposted;
    }
}
