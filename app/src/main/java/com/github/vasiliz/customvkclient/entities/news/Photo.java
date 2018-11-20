package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Photo extends Attachment implements Serializable {

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

    @Override
    public boolean equals(Object pO) {
        if (this == pO) {
            return true;
        }
        if (pO == null || getClass() != pO.getClass()) {
            return false;
        }
        if (!super.equals(pO)) {
            return false;
        }
        Photo photo = (Photo) pO;
        return mId == photo.mId &&
                mUserId == photo.mUserId &&
                mWidth == photo.mWidth &&
                mHeight == photo.mHeight &&
                Objects.equals(mPhoto604, photo.mPhoto604) &&
                Objects.equals(mText, photo.mText) &&
                Objects.equals(mPostId, photo.mPostId) &&
                Objects.equals(mAccessPhotoKey, photo.mAccessPhotoKey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), mPhoto604, mId, mUserId, mWidth, mHeight, mText, mPostId, mAccessPhotoKey);
    }
}
