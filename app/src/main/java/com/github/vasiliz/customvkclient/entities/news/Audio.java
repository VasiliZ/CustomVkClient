package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public  class Audio extends Attachment {
    @SerializedName("artist")
    private String mArtist;

    public Audio() {
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String pArtist) {
        mArtist = pArtist;
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
        Audio audio = (Audio) pO;
        return Objects.equals(mArtist, audio.mArtist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), mArtist);
    }
}
