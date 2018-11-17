package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("id")
    private long mId;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("sex")
    private String mSex;
    @SerializedName("screen_name")
    private String mScreenName;
    @SerializedName("photo_50")
    private String mUrlPhoto50;
    @SerializedName("photo_100")
    private String mUrlPhoto100;
    @SerializedName("online")
    private int mOnline;

    public Profile() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long pId) {
        mId = pId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String pSex) {
        mSex = pSex;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public void setScreenName(String pScreenName) {
        mScreenName = pScreenName;
    }

    public String getUrlPhoto50() {
        return mUrlPhoto50;
    }

    public void setUrlPhoto50(String pUrlPhoto50) {
        mUrlPhoto50 = pUrlPhoto50;
    }

    public String getUrlPhoto100() {
        return mUrlPhoto100;
    }

    public void setUrlPhoto100(String pUrlPhoto100) {
        mUrlPhoto100 = pUrlPhoto100;
    }

    public int getOnline() {
        return mOnline;
    }

    public void setOnline(int pOnline) {
        mOnline = pOnline;
    }
}
