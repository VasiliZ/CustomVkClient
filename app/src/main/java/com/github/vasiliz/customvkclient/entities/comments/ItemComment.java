package com.github.vasiliz.customvkclient.entities.comments;

import com.google.gson.annotations.SerializedName;

public class ItemComment {
    @SerializedName("id")
    private long id;
    @SerializedName("from_id")
    private long fromId;
    @SerializedName("text")
    private String textComment;

    public ItemComment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long pId) {
        id = pId;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long pFromId) {
        fromId = pFromId;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String pTextComment) {
        textComment = pTextComment;
    }
}
