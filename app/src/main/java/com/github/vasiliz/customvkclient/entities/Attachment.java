package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

public class Attachment {
    @SerializedName("type")
    private String mTypeAttachments;
    @SerializedName("photo")
    private Photo mPhotoType;

    public Attachment() {
    }

    public String getTypeAttachments() {
        return mTypeAttachments;
    }

    public void setTypeAttachments(String pTypeAttachments) {
        mTypeAttachments = pTypeAttachments;
    }

    public Photo getPhotoType() {
        return mPhotoType;
    }

    public void setPhotoType(Photo pPhotoType) {
        mPhotoType = pPhotoType;
    }
}
