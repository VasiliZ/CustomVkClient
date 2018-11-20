package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Group implements Serializable {

    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mNameGroup;
    @SerializedName("screen_name")
    private String mScreenName;
    @SerializedName("is_closed")
    private int mIsClosed;
    @SerializedName("type")
    private String mType;
    @SerializedName("photo_50")
    private String mUrlGroupPhoto50;
    @SerializedName("photo_100")
    private String mUrlGroupPhoto100;
    @SerializedName("photo_200")
    private String mUrlGroupPhoto200;

    public Group() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long pId) {
        mId = pId;
    }

    public String getNameGroup() {
        return mNameGroup;
    }

    public void setNameGroup(String pNameGroup) {
        mNameGroup = pNameGroup;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public void setScreenName(String pScreenName) {
        mScreenName = pScreenName;
    }

    public int getIsClosed() {
        return mIsClosed;
    }

    public void setIsClosed(int pIsClosed) {
        mIsClosed = pIsClosed;
    }

    public String getType() {
        return mType;
    }

    public void setType(String pType) {
        mType = pType;
    }

    public String getUrlGroupPhoto50() {
        return mUrlGroupPhoto50;
    }

    public void setUrlGroupPhoto50(String pUrlGroupPhoto50) {
        mUrlGroupPhoto50 = pUrlGroupPhoto50;
    }

    public String getUrlGroupPhoto100() {
        return mUrlGroupPhoto100;
    }

    public void setUrlGroupPhoto100(String pUrlGroupPhoto100) {
        mUrlGroupPhoto100 = pUrlGroupPhoto100;
    }

    public String getUrlGroupPhoto200() {
        return mUrlGroupPhoto200;
    }

    public void setUrlGroupPhoto200(String pUrlGroupPhoto200) {
        mUrlGroupPhoto200 = pUrlGroupPhoto200;
    }
}
