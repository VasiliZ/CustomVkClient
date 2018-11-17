package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("photo_604")
    private String mPhoto604;
    @SerializedName("id")
    private long mId;
    @SerializedName("user_id")
    private long mUserId;
    @SerializedName("width")
    private int mWidth;
    @SerializedName("height")
    private int mHeight;
    @SerializedName("text")
    private String mText;
    @SerializedName("post_id")
    private String mPostId;
    @SerializedName("access_key")
    private String mAccessPhotoKey;

    public Photo() {
    }

    public String getPhoto604() {
        return mPhoto604;
    }

    public void setPhoto604(String pPhoto604) {
        mPhoto604 = pPhoto604;
    }

    public long getId() {
        return mId;
    }

    public void setId(long pId) {
        mId = pId;
    }

    public long getUserId() {
        return mUserId;
    }

    public void setUserId(long pUserId) {
        mUserId = pUserId;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int pWidth) {
        mWidth = pWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int pHeight) {
        mHeight = pHeight;
    }

    public String getText() {
        return mText;
    }

    public void setText(String pText) {
        mText = pText;
    }

    public String getPostId() {
        return mPostId;
    }

    public void setPostId(String pPostId) {
        mPostId = pPostId;
    }

    public String getAccessPhotoKey() {
        return mAccessPhotoKey;
    }

    public void setAccessPhotoKey(String pAccessPhotoKey) {
        mAccessPhotoKey = pAccessPhotoKey;
    }
}
