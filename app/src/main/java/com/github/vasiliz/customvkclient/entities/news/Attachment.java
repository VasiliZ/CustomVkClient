package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Attachment implements Serializable, ItemModelI {
    @SerializedName("type")
    private String mTypeAttachments;
    @SerializedName("photo")
    private Photo mPhoto;
    @SerializedName("audio")
    private Audio mAudio;
    @SerializedName("video")
    private Video mVideo;

    public Attachment() {

    }

    public String getTypeAttachments() {
        return mTypeAttachments;
    }

    public void setTypeAttachments(String pTypeAttachments) {
        mTypeAttachments = pTypeAttachments;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo pPhoto) {
        mPhoto = pPhoto;
    }

    public Audio getAudio() {
        return mAudio;
    }

    public void setAudio(Audio pAudio) {
        mAudio = pAudio;
    }

    public Video getVideo() {
        return mVideo;
    }

    public void setVideo(Video pVideo) {
        mVideo = pVideo;
    }

    @Override
    public boolean equals(Object pO) {
        if (this == pO) {
            return true;
        }
        if (pO == null || getClass() != pO.getClass()) {
            return false;
        }
        Attachment that = (Attachment) pO;
        return Objects.equals(mTypeAttachments, that.mTypeAttachments) &&
                Objects.equals(mPhoto, that.mPhoto) &&
                Objects.equals(mAudio, that.mAudio) &&
                Objects.equals(mVideo, that.mVideo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mTypeAttachments, mPhoto, mAudio, mVideo);
    }
}
