package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    @SerializedName("type")
    private String mType;
    @SerializedName("source_id")
    private int mSourseId;
    @SerializedName("date")
    private long mDate;
    @SerializedName("post_id")
    private int mPostId;
    @SerializedName("post_type")
    private String mPostType;
    @SerializedName("text")
    private String mText;
    @SerializedName("attachments")
    private List<Attachment> mAttachments;
    @SerializedName("comments")
    private Comments mComments;
    @SerializedName("likes")
    private Likes mLikes;
    @SerializedName("reposts")
    private Reposts mReposts;
    @SerializedName("views")
    private Views mViews;

    public Item() {
    }

    public String getType() {
        return mType;
    }

    public void setType(String pType) {
        mType = pType;
    }

    public int getSourseId() {
        return mSourseId;
    }

    public void setSourseId(int pSourseId) {
        mSourseId = pSourseId;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long pDate) {
        mDate = pDate;
    }

    public int getPostId() {
        return mPostId;
    }

    public void setPostId(int pPostId) {
        mPostId = pPostId;
    }

    public String getPostType() {
        return mPostType;
    }

    public void setPostType(String pPostType) {
        mPostType = pPostType;
    }

    public String getText() {
        return mText;
    }

    public void setText(String pText) {
        mText = pText;
    }

    public List<Attachment> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(List<Attachment> pAttachments) {
        mAttachments = pAttachments;
    }

    public Comments getComments() {
        return mComments;
    }

    public void setComments(Comments pComments) {
        mComments = pComments;
    }

    public Likes getLikes() {
        return mLikes;
    }

    public void setLikes(Likes pLikes) {
        mLikes = pLikes;
    }

    public Reposts getReposts() {
        return mReposts;
    }

    public void setReposts(Reposts pReposts) {
        mReposts = pReposts;
    }

    public Views getViews() {
        return mViews;
    }

    public void setViews(Views pViews) {
        mViews = pViews;
    }
}
